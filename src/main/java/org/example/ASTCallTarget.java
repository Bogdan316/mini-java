/* Generated By:JJTree: Do not edit this line. ASTCallTarget.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.example;

public
class ASTCallTarget extends SimpleNode {
    Token intArr;
    ASTExpArm idxExp;
    Token clsName;
    Token localVar;
    Token thiz;

    public ASTCallTarget(int id) {
        super(id);
    }

    public ASTCallTarget(MiniJavaParser p, int id) {
        super(p, id);
    }


    /**
     * Accept the visitor.
     **/
    public Object jjtAccept(MiniJavaParserVisitor visitor, Object data) {

        return
                visitor.visit(this, data);
    }
}
/* JavaCC - OriginalChecksum=14d3c4981a0d3e8c6b07db80cd19925e (do not edit this line) */
