/* Generated By:JJTree: Do not edit this line. ASTType.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.example;

public
class ASTType extends SimpleNode {
  String name;
  public ASTType(int id) {
    super(id);
  }

  public ASTType(MiniJavaParser p, int id) {
    super(p, id);
  }

  public void setName(String name) {
    this.name = name;
  }

  /** Accept the visitor. **/
  public Object jjtAccept(MiniJavaParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=764d11eeb33400162da2a3f0718e0e19 (do not edit this line) */
