/* Generated By:JJTree: Do not edit this line. ASTExpLog2.java Version 7.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.example;

public
class ASTExpLog2 extends SimpleNode {
  public ASTExpLog2(int id) {
    super(id);
  }

  public ASTExpLog2(MiniJavaParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(MiniJavaParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=23f515c820085e5b95cdfa7c0aee407c (do not edit this line) */