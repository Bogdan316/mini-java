package org.example;

public class TypeCheckingVisitor extends MiniJavaParserDefaultVisitor{
    @Override
    public Object visit(ASTCallTarget node, Object data) {
        return super.visit(node, data);
    }
}
