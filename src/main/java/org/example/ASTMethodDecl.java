/* Generated By:JJTree: Do not edit this line. ASTMethodDecl.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.example;

public
class ASTMethodDecl extends SimpleNode {
  public ASTMethodDecl(int id) {
    super(id);
  }

  public ASTMethodDecl(MiniJavaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJavaParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=ffdb0971ac37e123fab281ecd49247bc (do not edit this line) */
