package org.example;

import java.util.Arrays;

public class TypeCheckingVisitor extends MiniJavaParserDefaultVisitor {
    private static void isBoolean(SimpleNode node) {
        if (node.type.t() != Types.TYPE || !node.type.name().equals("boolean")) {
            throw new RuntimeException("Expected boolean");
        }
    }

    private static void isInt(SimpleNode node) {
        if (node.type.t() != Types.TYPE || !node.type.name().equals("int")) {
            throw new RuntimeException("Expected int");
        }
    }

    @Override
    public Object visit(ASTExp node, Object data) {
        super.visit(node, data);
        node.type = node.cond.type;
        return null;
    }

    @Override
    public Object visit(ASTCondition node, Object data) {
        super.visit(node, data);
        if (node.exp != null) {
            node.type = node.exp.type;
        } else {
            node.type = node.notExp.type;
        }
        return null;
    }

    @Override
    public Object visit(ASTExpLog node, Object data) {
        super.visit(node, data);
        if (node.rel == null) {
            if (node.log == null) {
                node.type = new TypeId(Types.TYPE, "boolean");
            } else {
                isBoolean(node.log);
                node.type = node.log.type;
            }
        } else {
            if (node.log == null) {
                node.type = node.rel.type;
            } else {
                System.out.println(node.log.type);
                isBoolean(node.log);
                node.type = node.log.type;
            }
        }
        return null;
    }

    @Override
    public Object visit(ASTExpLog2 node, Object data) {
        super.visit(node, data);
        if(node.rel != null) {
            isBoolean(node.rel);
        }
        node.type = new TypeId(Types.TYPE, "boolean");
        return null;
    }

    @Override
    public Object visit(ASTExpRel node, Object data) {
        super.visit(node, data);
        if (node.cond != null) {
            node.type = node.cond.type;
        } else if (node.expArm != null && node.expArm2 != null) {
            node.type = new TypeId(Types.TYPE, "boolean");
            isInt(node.expArm);
            isBoolean(node.expArm2);
        } else {
            node.type = node.expArm.type;
        }
        return null;
    }

    @Override
    public Object visit(ASTExpArm node, Object data) {
        super.visit(node, data);
        node.type = node.term.type;
        if (node.arm != null) {
            isInt(node.term);
            isInt(node.arm);
        }
        return null;
    }

    @Override
    public Object visit(ASTExpArm2 node, Object data) {
        if(node.term == null) {
            return null;
        }

        super.visit(node, data);
        isInt(node.term);
        if (node.arm != null) {
            isInt(node.arm);
        }
        node.type = new TypeId(Types.TYPE, "int");
        return null;
    }

    @Override
    public Object visit(ASTExpTerm node, Object data) {
        super.visit(node, data);
        node.type = node.fact.type;
        if (node.term != null) {
            isInt(node.fact);
            isInt(node.term);
        }
        return null;
    }

    @Override
    public Object visit(ASTExpTerm2 node, Object data) {
        super.visit(node, data);

        node.type = new TypeId(Types.TYPE, "int");
        if(node.fact != null) {
            isInt(node.fact);
        }
        if (node.term != null) {
            isInt(node.term);
        }
        return null;
    }

    @Override
    public Object visit(ASTExpFact node, Object data) {
        super.visit(node, data);
        if (node.integer != null) {
            node.type = new TypeId(Types.TYPE, "int");
        } else if (node.expArm != null) {
            isInt(node.expArm);
            node.type = new TypeId(Types.TYPE, "int");
        } else {
            node.type = node.access.type;
        }
        return null;
    }

    @Override
    public Object visit(ASTAccess node, Object data) {
        super.visit(node, data);
        if (node.exp != null) {
            node.type = new TypeId(Types.TYPE, "int");
            isInt(node.call);
            isInt(node.exp);
        } else {
            node.type = node.call.type;
        }
        return null;
    }

    @Override
    public Object visit(ASTCall node, Object data) {
        super.visit(node, data);
//        TODO: todo
        node.type = new TypeId(Types.TYPE, "asdasdasd");
        return null;
    }

    @Override
    public Object visit(ASTCall2 node, Object data) {
        super.visit(node, data);
        if (node.length != null) {
            node.type = new TypeId(Types.TYPE, "int");
        } else if (node.id != null && node.call == null) {
             node.type = new TypeId(Types.CALL, "method call");
        } else {
            node.type = node.call.type;
        }
        return null;
    }

    @Override
    public Object visit(ASTCallTarget node, Object data) {
        super.visit(node, data);
        if (node.intArr != null) {
            node.type = new TypeId(Types.TYPE, "int[]");
            isInt(node.idxExp);
        } else if(node.clsName != null) {
            node.type = new TypeId(Types.TYPE, node.clsName.image);
        } else if(node.localVar != null) {
            // TODO: todo
            node.type = new TypeId(Types.LOCAL_VAR, "Asd");
        } else {
             node.type = new TypeId(Types.THIS);
        }
        return null;
    }
}
