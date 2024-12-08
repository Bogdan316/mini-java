/* Generated By:JavaCC: Do not edit this line. MiniJavaParserVisitor.java Version 7.0.13 */
package org.example;

public interface MiniJavaParserVisitor
{
  public Object visit(SimpleNode node, Object data);
  public Object visit(ASTProgram node, Object data);
  public Object visit(ASTMainClass node, Object data);
  public Object visit(ASTClassDecl node, Object data);
  public Object visit(ASTVarDecl node, Object data);
  public Object visit(ASTMethodDecl node, Object data);
  public Object visit(ASTFormalList node, Object data);
  public Object visit(ASTFormalRest node, Object data);
  public Object visit(ASTType node, Object data);
  public Object visit(ASTStatement node, Object data);
  public Object visit(ASTExp node, Object data);
  public Object visit(ASTCondition node, Object data);
  public Object visit(ASTLogExp node, Object data);
  public Object visit(ASTLogExpTerm node, Object data);
  public Object visit(ASTLogExpFactor node, Object data);
  public Object visit(ASTRelExp node, Object data);
  public Object visit(ASTRelOp node, Object data);
  public Object visit(ASTArExp node, Object data);
  public Object visit(ASTAddOp node, Object data);
  public Object visit(ASTTerm node, Object data);
  public Object visit(ASTMulOp node, Object data);
  public Object visit(ASTFactor node, Object data);
}
/* JavaCC - OriginalChecksum=d068d45c3665624609908526308665d2 (do not edit this line) */