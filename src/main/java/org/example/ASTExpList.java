/* Generated By:JJTree: Do not edit this line. ASTExpList.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.example;

public
class ASTExpList extends SimpleNode {
  public ASTExpList(int id) {
    super(id);
  }

  public ASTExpList(MiniJavaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJavaParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=7f64801f47fce4db716a98b790c10e58 (do not edit this line) */
