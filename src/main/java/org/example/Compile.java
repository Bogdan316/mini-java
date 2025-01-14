package org.example;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

interface CpInfo {
    int getTag();

    void write(ByteArrayOutputStream buff);
}

record ClassInfo(int nameIdx) implements CpInfo {

    @Override
    public int getTag() {
        return 7;
    }

    @Override
    public void write(ByteArrayOutputStream buff) {
        buff.write(getTag());
        writeDoubleByte(buff, nameIdx);

    }

    private void writeDoubleByte(ByteArrayOutputStream buff, int i) {
        buff.write((i & 0xFF00) >> 8);
        buff.write(i & 0xFF);
    }
}

record FieldRef(int classIdx, int nameAndTypeIdx) implements CpInfo {
    @Override
    public int getTag() {
        return 9;
    }

    @Override
    public void write(ByteArrayOutputStream buff) {
        buff.write(getTag());
        writeDoubleByte(buff, classIdx);
        writeDoubleByte(buff, nameAndTypeIdx);
    }

    private void writeDoubleByte(ByteArrayOutputStream buff, int i) {
        buff.write((i & 0xFF00) >> 8);
        buff.write(i & 0xFF);
    }
}

record MethodRef(int classIdx, int nameAndTypeIdx) implements CpInfo {
    @Override
    public int getTag() {
        return 10;
    }

    @Override
    public void write(ByteArrayOutputStream buff) {
        buff.write(getTag());
        writeDoubleByte(buff, classIdx);
        writeDoubleByte(buff, nameAndTypeIdx);
    }

    private void writeDoubleByte(ByteArrayOutputStream buff, int i) {
        buff.write((i & 0xFF00) >> 8);
        buff.write(i & 0xFF);
    }
}

record NameAndType(int nameIdx, int descIndex) implements CpInfo {

    @Override
    public int getTag() {
        return 12;
    }

    @Override
    public void write(ByteArrayOutputStream buff) {
        buff.write(getTag());
        writeDoubleByte(buff, nameIdx);
        writeDoubleByte(buff, descIndex);
    }

    private void writeDoubleByte(ByteArrayOutputStream buff, int i) {
        buff.write((i & 0xFF00) >> 8);
        buff.write(i & 0xFF);
    }
}

record Utf8(String str) implements CpInfo {

    @Override
    public int getTag() {
        return 1;
    }

    @Override
    public void write(ByteArrayOutputStream buff) {
        buff.write(getTag());
        var bArr = str.getBytes(StandardCharsets.UTF_8);
        int len = bArr.length;
        writeDoubleByte(buff, len);
        try {
            buff.write(bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDoubleByte(ByteArrayOutputStream buff, int i) {
        buff.write((i & 0xFF00) >> 8);
        buff.write(i & 0xFF);
    }
}

record FieldInfo(int accessFlags, int nameIdx, int descIdx, int atrCount) {
    public void write(ByteArrayOutputStream buff) {
        writeDoubleByte(buff, accessFlags);
        writeDoubleByte(buff, nameIdx);
        writeDoubleByte(buff, descIdx);
        writeDoubleByte(buff, atrCount);
    }

    private void writeDoubleByte(ByteArrayOutputStream buff, int i) {
        buff.write((i & 0xFF00) >> 8);
        buff.write(i & 0xFF);
    }
}

record MethodInfo(int accessFlags, int nameIdx, int descIdx, int atrCount) {
    public void write(ByteArrayOutputStream buff) {
        writeDoubleByte(buff, accessFlags);
        writeDoubleByte(buff, nameIdx);
        writeDoubleByte(buff, descIdx);
        writeDoubleByte(buff, atrCount);
    }

    private void writeDoubleByte(ByteArrayOutputStream buff, int i) {
        buff.write((i & 0xFF00) >> 8);
        buff.write(i & 0xFF);
    }
}

public class Compile {
    private final Map<String, String> typeNames = Map.of(
            "int", "I",
            "boolean", "Z",
            "int[]", "[I",
            "String[]", "[Ljava/lang/String;",
            "void", "V"
    );

    private final List<CpInfo> constPool = new ArrayList<>();

    private final List<TypeRow> types;
    private final List<ClassRow> classes;

    public Compile(List<TypeRow> types, List<ClassRow> classes) {
        this.types = types;
        this.classes = classes;
    }

    private String getType(String type) {

        var t = typeNames.get(type);
        if (t == null) {
            return "L" + type.replace('.', '/') + ";";
        }
        return t;
    }

    private int addCpInfo(CpInfo cpInfo) {
        int idx = constPool.indexOf(cpInfo);
        if (idx < 0) {
            constPool.add(cpInfo);
            idx = constPool.size() - 1;
        }
        return idx;
    }

    public void compile() {
        try {
            for (var type : types) {
                if (type.clsIdx() == -1 || type.typeName().equals("Object")) {
                    continue;
                }
                constPool.clear();
                var buff = new ByteArrayOutputStream();
                constPool.add(new Utf8(""));
                for (var t : types) {
                    if (t.clsIdx() == -1) {
                        continue;
                    }
                    addCpInfo(new Utf8(t.typeName()));
                }
                var fieldInfo = new ArrayList<FieldInfo>();
                var methodInfo = new ArrayList<MethodInfo>();


                int nameIdx = addCpInfo(new Utf8(type.typeName()));
                int classIdx = addCpInfo(new ClassInfo(nameIdx));
                var cls = classes.get(type.clsIdx());
                for (var member : cls.members()) {
                    int name = addCpInfo(new Utf8(member.name()));
                    var retType = getType(types.get(member.returnTypeIdx()).typeName());
                    if (member.kind() == MemberKind.FIELD) {
                        int fieldType = addCpInfo(new Utf8(retType));
                        int descIdx = addCpInfo(new NameAndType(name, fieldType));
                        addCpInfo(new FieldRef(classIdx, descIdx));
                        fieldInfo.add(new FieldInfo(1, name, fieldType, 0));
                    } else {
                        String sign = Arrays.stream(member.signature()).skip(1)
                                .map(this::getType).collect(Collectors.joining());
                        int signature = addCpInfo(new Utf8("(" + sign + ")" + retType));
                        int descIdx = addCpInfo(new NameAndType(name, signature));
                        addCpInfo(new MethodRef(classIdx, descIdx));
                        methodInfo.add(new MethodInfo(1, name, signature, 0));
                    }
                }

                buff.write(0xca);
                buff.write(0xfe);
                buff.write(0xba);
                buff.write(0xbe);

                buff.write(0x00);
                buff.write(0x00);

                buff.write(0x00);
                buff.write(0x3d);

                int thisNameIdx = addCpInfo(new Utf8(cls.clsName()));
                int thisClassIdx = addCpInfo(new ClassInfo(thisNameIdx));

                int j = 0;
                var parent = classes.get(cls.parentIdx());
                for (var t : types) {
                    if (t.typeName().equals(parent.clsName())) {
                        break;
                    }
                    j++;
                }
                String parentName = types.get(j).typeName();
                int superNameIdx = addCpInfo(new Utf8(types.get(j).typeName()));
                int superClassIdx = addCpInfo(new ClassInfo(superNameIdx));

                int len = constPool.size();
                buff.write((len & 0xFF00) >> 8);
                buff.write(len & 0xFF);
                for (int i = 1; i < constPool.size(); i++) {
                    constPool.get(i).write(buff);
                }

                buff.write(0x01);
                buff.write(0x00);

                buff.write((thisClassIdx & 0xFF00) >> 8);
                buff.write(thisClassIdx & 0xFF);

                if (parentName.equals("Object")) {
                    buff.write(0);
                    buff.write(0);
                } else {
                    buff.write((superClassIdx & 0xFF00) >> 8);
                    buff.write(superClassIdx & 0xFF);
                }

                buff.write(0x00);
                buff.write(0x00);

                len = fieldInfo.size();
                buff.write((len & 0xFF00) >> 8);
                buff.write(len & 0xFF);
                for (var info : fieldInfo) {
                    info.write(buff);
                }

                len = methodInfo.size();
                buff.write((len & 0xFF00) >> 8);
                buff.write(len & 0xFF);
                for (var info : methodInfo) {
                    info.write(buff);
                }

                buff.write(0x00);
                buff.write(0x00);

                try (var f = new FileOutputStream(cls.clsName() + ".class")) {
                    f.write(buff.toByteArray());
                }

                for (int i = 1; i < constPool.size(); i++) {
                    System.out.println(i + "->" + constPool.get(i) + " " + constPool.get(i).getTag());
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
