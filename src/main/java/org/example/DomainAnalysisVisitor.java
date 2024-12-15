package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

record ClassRow(String clsName, int parentIdx, List<MemberRow> members){
    public ClassRow(String clsName, int parentIdx) {
        this(clsName, parentIdx, new ArrayList<>());
    }

    public ClassRow(String clsName) {
        this(clsName, -1);
    }
}

record TypeRow(String typeName, int clsIdx) {
}

enum MemberKind {
    METHOD,
    FIELD;
}

record FormalParameterRow(String name, String[] signature, String type) {
    @Override
    public String toString() {
        return "FormalParameterRow{" +
                "name='" + name + '\'' +
                ", signature=" + Arrays.toString(signature) +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormalParameterRow that = (FormalParameterRow) o;
        return Objects.equals(name, that.name) && Arrays.equals(signature, that.signature) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, type);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }
}

record LocalVarsRow(String name, String[] signature, String returnType) {
    @Override
    public String toString() {
        return "LocalVarsRow{" +
                "name='" + name + '\'' +
                ", signature=" + Arrays.toString(signature) +
                ", returnType='" + returnType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalVarsRow that = (LocalVarsRow) o;
        return Objects.equals(name, that.name) && Arrays.equals(signature, that.signature) && Objects.equals(returnType, that.returnType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, returnType);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }
}

record MemberRow(String name, String[] signature, String returnType, MemberKind kind,
                 List<FormalParameterRow> formalParams, List<LocalVarsRow> locals) {
    public MemberRow(String name, String[] signature, String returnType, MemberKind kind) {
        this(name, signature, returnType, kind, new ArrayList<>(), new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberRow memberRow = (MemberRow) o;
        return Objects.equals(name, memberRow.name) && Arrays.equals(signature, memberRow.signature) && Objects.equals(returnType, memberRow.returnType) && kind == memberRow.kind && Objects.equals(formalParams, memberRow.formalParams) && Objects.equals(locals, memberRow.locals);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, returnType, kind, formalParams, locals);
        result = 31 * result + Arrays.hashCode(signature);
        return result;
    }

    @Override
    public String toString() {
        return "MemberRow{" +
                "name='" + name + '\'' +
                ", signature=" + Arrays.toString(signature) +
                ", returnType='" + returnType + '\'' +
                ", kind=" + kind +
                ", formalParams=" + formalParams +
                ", locals=" + locals +
                '}';
    }
}

public class DomainAnalysisVisitor implements MiniJavaParserVisitor {
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

    private ClassRow addClassRow(String clsName, String parentName) {
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
        return row;
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
                typeTable.add(new TypeRow(name, classTable.size()));
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

    @Override
    public Object visit(SimpleNode node, Object data) {
        return node.childrenAccept(this, data);
    }

    @Override
    public Object visit(ASTProgram node, Object data) {
        return visit((SimpleNode) node, data);
    }

    @Override
    public Object visit(ASTMainClass node, Object data) {
        addType(node.name, "Object");
        return visit((SimpleNode) node, data);
    }

    @Override
    public Object visit(ASTClassDecl node, Object data) {
        var parent = Objects.requireNonNullElse(node.parent, "Object");
        addType(node.name, parent);
        var classRow = classTable.get(findClass(node.name));
        for (var field : node.fields) {
            classRow.members().add(
                    new MemberRow(
                            field.name,
                            new String[]{field.name},
                            field.typeNode.name,
                            MemberKind.FIELD
                    )
            );
        }
        for (var method : node.methods) {
            var sign = Stream.concat(Stream.of(method.name), method.paramTypes.stream())
                    .toArray(String[]::new);
            var memberRow = new MemberRow(
                    method.name,
                    sign,
                    method.returnType.name,
                    MemberKind.METHOD
            );

            var typesIt = method.paramTypes.iterator();
            var namesIt = method.paramNames.iterator();
            while (typesIt.hasNext() && namesIt.hasNext()) {
                var type = typesIt.next();
                var name = namesIt.next();
                memberRow.formalParams().add(new FormalParameterRow(name, new String[]{name}, type));
            }

            for (var local : method.locals) {
                memberRow.locals().add(new LocalVarsRow(local.name, new String[]{local.name}, local.typeNode.name));
            }
            classRow.members().add(memberRow);
        }
        return visit((SimpleNode) node, data);
    }

    @Override
    public Object visit(ASTVarDecl node, Object data) {
        return visit((SimpleNode) node, data);
    }

    @Override
    public Object visit(ASTMethodDecl node, Object data) {
        return visit((SimpleNode) node, data);
    }

    @Override
    public Object visit(ASTType node, Object data) {
        addType(node.name);
        return visit((SimpleNode) node, data);
    }
}
