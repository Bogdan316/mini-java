/* Generated By:JJTree: Do not edit this line. ASTExpFact.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.example;

public
class ASTExpFact extends SimpleNode {
    Token integer;
    ASTExpArm expArm;
    ASTAccess access;

    public ASTExpFact(int id) {
        super(id);
    }

    public ASTExpFact(MiniJavaParser p, int id) {
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
/* JavaCC - OriginalChecksum=87d571ae399c006364950dfea3d672b1 (do not edit this line) */
