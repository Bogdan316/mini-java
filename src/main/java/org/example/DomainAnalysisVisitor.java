package org.example;


import java.util.*;
import java.util.stream.Stream;

record ClassRow(String clsName, int parentIdx, List<MemberRow> members) {
    public ClassRow(String clsName, int parentIdx) {
        this(clsName, parentIdx, new ArrayList<>());
    }

    public void addMember(MemberRow memberRow) {
        for (var m : members) {
            if (Arrays.equals(m.signature(), memberRow.signature())) {
                throw new RuntimeException(m.kind() + " with signature '" + Arrays.toString(memberRow.signature()) + "' already defined");
            }
        }

        members.add(memberRow);
    }
}

record TypeRow(String typeName, int clsIdx) {
}

enum MemberKind {
    METHOD,
    FIELD;
}

record FormalParameterRow(String name, String[] signature, int typeIdx) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormalParameterRow that = (FormalParameterRow) o;
        return typeIdx == that.typeIdx && Objects.equals(name, that.name) && Arrays.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, typeIdx);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }

    @Override
    public String toString() {
        return "FormalParameterRow{" +
                "name='" + name + '\'' +
                ", signature=" + Arrays.toString(signature) +
                ", typeIdx=" + typeIdx +
                '}';
    }
}

record LocalVarsRow(String name, String[] signature, int returnTypeIdx) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalVarsRow that = (LocalVarsRow) o;
        return returnTypeIdx == that.returnTypeIdx && Objects.equals(name, that.name) && Arrays.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, returnTypeIdx);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }

    @Override
    public String toString() {
        return "LocalVarsRow{" +
                "name='" + name + '\'' +
                ", signature=" + Arrays.toString(signature) +
                ", returnTypeIdx=" + returnTypeIdx +
                '}';
    }
}

record MemberRow(String name, String[] signature, int returnTypeIdx, MemberKind kind,
                 List<FormalParameterRow> formalParams, List<LocalVarsRow> locals) {
    public MemberRow(String name, String[] signature, int returnType, MemberKind kind) {
        this(name, signature, returnType, kind, new ArrayList<>(), new ArrayList<>());
    }

    public void addLocal(LocalVarsRow local) {
        for (var v : locals) {
            if (v.name().equals(local.name())) {
                throw new RuntimeException("Variable with name '" + local.name() + "' already defined");
            }
        }

        for (var v : formalParams) {
            if (v.name().equals(local.name())) {
                throw new RuntimeException("Param with name '" + local.name() + "' already defined");
            }
        }

        locals.add(local);
    }

    public void addFormalParam(FormalParameterRow param) {
        for (var v : formalParams) {
            if (v.name().equals(param.name())) {
                throw new RuntimeException("Param with name '" + param.name() + "' already defined");
            }
        }

        formalParams.add(param);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberRow memberRow = (MemberRow) o;
        return returnTypeIdx == memberRow.returnTypeIdx && Objects.equals(name, memberRow.name) && Arrays.equals(signature, memberRow.signature) && kind == memberRow.kind && Objects.equals(formalParams, memberRow.formalParams) && Objects.equals(locals, memberRow.locals);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, returnTypeIdx, kind, formalParams, locals);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }

    @Override
    public String toString() {
        return "MemberRow{" +
                "name='" + name + '\'' +
                ", signature=" + Arrays.toString(signature) +
                ", returnTypeIdx=" + returnTypeIdx +
                ", kind=" + kind +
                ", formalParams=" + formalParams +
                ", locals=" + locals +
                '}';
    }
}

public class DomainAnalysisVisitor extends MiniJavaParserDefaultVisitor {
    List<ClassRow> classTable = new ArrayList<>();
    List<TypeRow> typeTable = new ArrayList<>();

    public DomainAnalysisVisitor() {
        classTable.add(new ClassRow("Object", -1));

        typeTable.add(new TypeRow("void", -1));
        typeTable.add(new TypeRow("boolean", -1));
        typeTable.add(new TypeRow("int", -1));
        typeTable.add(new TypeRow("int[]", -1));
        typeTable.add(new TypeRow("Object", 0));
    }

    private void addClassRow(String clsName, String parentName) {
        for (var r : classTable) {
            if (r.clsName().equals(clsName)) {
                throw new RuntimeException("Class '" + clsName + "' is already defined.");
            }
        }

        int parentIdx = -1;
        for (int i = 0; i < classTable.size(); i++) {
            var cls = classTable.get(i);
            if (cls.clsName().equals(parentName)) {
                parentIdx = i;
            }
        }

        var row = new ClassRow(clsName, parentIdx);
        classTable.add(row);
    }

    private int findClass(String name) {
        int found = -1;
        for (var r : classTable) {
            found++;
            if (r.clsName().equals(name)) {
                return found;
            }
        }
        return -1;
    }

    private int findType(String name) {
        if (name == null) {
            return -1;
        }

        int found = -1;
        for (var t : typeTable) {
            found++;
            if (t.typeName().equals(name)) {
                return found;
            }
        }

        return -1;
    }

    private void addType(String name, String parent) {
        if (parent != null) {
            addType(parent);
        }
        int typeIdx = findType(name);
        // primitives
        if (typeIdx < 5 && typeIdx > 0) {
            return;
        }

        int parentIdx = findClass(parent);
        int clsIdx = findClass(name);
        if (clsIdx < 0) {
            addClassRow(name, parent);
            if (typeIdx < 0) {
                typeTable.add(new TypeRow(name, classTable.size() - 1));
            }
        } else {
            var cls = classTable.get(clsIdx);
            if (cls.parentIdx() != parentIdx && parentIdx != -1) {
                classTable.set(clsIdx, new ClassRow(cls.clsName(), parentIdx, cls.members()));
            }
        }
    }

    private void addType(String name) {
        addType(name, null);
    }


    private void checkCycles(int idx, ClassRow row) {
        var visited = new HashSet<Integer>();
        while (row.parentIdx() != -1) {
            visited.add(idx);
            idx = row.parentIdx();
            row = classTable.get(idx);
            if (visited.contains(idx)) {
                throw new RuntimeException("Cyclic inheritance for class '" + row.clsName() + "'");
            }
            visited.add(idx);
        }
    }

    @Override
    public Object visit(ASTMainClass node, Object data) {
        addType(node.name, "Object");
        int idx = findClass(node.name);
        var classRow = classTable.get(idx);
        checkCycles(idx, classRow);

        var memberRow = new MemberRow(
                "main",
                new String[]{"main", "String[]"},
                findType("void"),
                MemberKind.METHOD
        );

        for (var local : node.locals) {
            addType(local.typeNode.name);
            memberRow.addLocal(new LocalVarsRow(local.name, new String[]{local.name}, findType(local.typeNode.name)));
        }

        classRow.addMember(memberRow);
        return super.visit(node, data);
    }

    @Override
    public Object visit(ASTClassDecl node, Object data) {
        var parent = Objects.requireNonNullElse(node.parent, "Object");
        int idx = findClass(node.name);
        if (idx >= 0 && classTable.get(idx).parentIdx() != -1) {
            throw new RuntimeException("Class with name '" + node.name + "' already defined");
        }

        addType(node.name, parent);
        idx = findClass(node.name);
        var classRow = classTable.get(idx);
        checkCycles(idx, classRow);

        for (var field : node.fields) {
            addType(field.typeNode.name);
            classRow.addMember(
                    new MemberRow(
                            field.name,
                            new String[]{field.name},
                            findType(field.typeNode.name),
                            MemberKind.FIELD
                    )
            );
        }
        for (var method : node.methods) {
            var sign = Stream.concat(Stream.of(method.name), method.paramTypes.stream())
                    .toArray(String[]::new);
            addType(method.returnType.name);
            var memberRow = new MemberRow(
                    method.name,
                    sign,
                    findType(method.returnType.name),
                    MemberKind.METHOD
            );

            var typesIt = method.paramTypes.iterator();
            var namesIt = method.paramNames.iterator();
            while (typesIt.hasNext() && namesIt.hasNext()) {
                var type = typesIt.next();
                var name = namesIt.next();
                addType(type);
                memberRow.addFormalParam(new FormalParameterRow(name, new String[]{name}, findType(type)));
            }

            for (var local : method.locals) {
                addType(local.typeNode.name);
                memberRow.addLocal(new LocalVarsRow(local.name, new String[]{local.name}, findType(local.typeNode.name)));
            }
            classRow.addMember(memberRow);
        }
        return super.visit(node, data);
    }

    @Override
    public Object visit(ASTType node, Object data) {
        addType(node.name);
        return super.visit(node, data);
    }
}
