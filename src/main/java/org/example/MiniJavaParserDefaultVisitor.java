/* Generated By:JavaCC: Do not edit this line. MiniJavaParserDefaultVisitor.java Version 7.0.13 */
package org.example;

public class MiniJavaParserDefaultVisitor implements MiniJavaParserVisitor{
  public Object defaultVisit(SimpleNode node, Object data){
    node.childrenAccept(this, data);
    return data;
  }
  public Object visit(SimpleNode node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTProgram node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTMainClass node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTClassDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTVarDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTMethodDecl node, Object data){
    return defaultVisit(node, data);
  }
  public Object visit(ASTType node, Object data){
    return defaultVisit(node, data);
  }
}
/* JavaCC - OriginalChecksum=154f2e37c655e5ccca4665515d8503fa (do not edit this line) */
