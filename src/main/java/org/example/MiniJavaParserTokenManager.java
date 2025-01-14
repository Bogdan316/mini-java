/* MiniJavaParserTokenManager.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. MiniJavaParserTokenManager.java */
package org.example;
import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

/** Token Manager. */
@SuppressWarnings ("unused")
public class MiniJavaParserTokenManager implements MiniJavaParserConstants {

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x20020L) != 0L)
         {
            jjmatchedKind = 22;
            return 3;
         }
         if ((active0 & 0x1dff5eL) != 0L)
         {
            jjmatchedKind = 22;
            return 7;
         }
         return -1;
      case 1:
         if ((active0 & 0x20L) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 1;
            return 0;
         }
         if ((active0 & 0x20000L) != 0L)
            return 7;
         if ((active0 & 0x1dff5eL) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 1;
            return 7;
         }
         return -1;
      case 2:
         if ((active0 & 0x20L) != 0L)
            return 1;
         if ((active0 & 0x1dff4eL) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 2;
            return 7;
         }
         if ((active0 & 0x10L) != 0L)
            return 7;
         return -1;
      case 3:
         if ((active0 & 0x19ae4cL) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 3;
            return 7;
         }
         if ((active0 & 0x45102L) != 0L)
            return 7;
         return -1;
      case 4:
         if ((active0 & 0x82400L) != 0L)
            return 7;
         if ((active0 & 0x118a4cL) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 4;
            return 7;
         }
         return -1;
      case 5:
         if ((active0 & 0x100840L) != 0L)
         {
            jjmatchedKind = 22;
            jjmatchedPos = 5;
            return 7;
         }
         if ((active0 & 0x1820cL) != 0L)
            return 7;
         return -1;
      case 6:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         if ((active0 & 0x840L) != 0L)
            return 7;
         return -1;
      case 7:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      case 8:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      case 9:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      case 10:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      case 11:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      case 12:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      case 13:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      case 14:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      case 15:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      case 16:
         if ((active0 & 0x100000L) != 0L)
         {
            if (jjmatchedPos < 5)
            {
               jjmatchedKind = 22;
               jjmatchedPos = 5;
            }
            return -1;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 9:
         return jjStopAtPos(0, 24);
      case 10:
         return jjStopAtPos(0, 25);
      case 13:
         return jjStopAtPos(0, 26);
      case 32:
         return jjStopAtPos(0, 23);
      case 33:
         jjmatchedKind = 38;
         return jjMoveStringLiteralDfa1_0(0x40000000000L);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 40:
         return jjStopAtPos(0, 30);
      case 41:
         return jjStopAtPos(0, 33);
      case 42:
         return jjStopAtPos(0, 49);
      case 43:
         return jjStopAtPos(0, 47);
      case 44:
         return jjStopAtPos(0, 36);
      case 45:
         return jjStopAtPos(0, 48);
      case 46:
         return jjStopAtPos(0, 51);
      case 59:
         return jjStopAtPos(0, 35);
      case 60:
         jjmatchedKind = 43;
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 61:
         jjmatchedKind = 37;
         return jjMoveStringLiteralDfa1_0(0x20000000000L);
      case 62:
         jjmatchedKind = 44;
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 83:
         return jjMoveStringLiteralDfa1_0(0x100008L);
      case 91:
         return jjStopAtPos(0, 31);
      case 93:
         return jjStopAtPos(0, 32);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x40800L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x20020L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x4L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x2L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x10L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x10000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x5000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x80000L);
      case 123:
         return jjStopAtPos(0, 29);
      case 124:
         jjmatchedKind = 50;
         return jjMoveStringLiteralDfa1_0(0x10000000000L);
      case 125:
         return jjStopAtPos(0, 34);
      default :
         return jjMoveNfa_0(4, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(1, 39);
         break;
      case 61:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStopAtPos(1, 41);
         else if ((active0 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 42);
         else if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 45);
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 46);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x2002L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x10014L);
      case 102:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(1, 17, 7);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x84000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x40400L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x20L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x140L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x8008L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 121:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 124:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStopAtPos(1, 40);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x8400L);
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x84102L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x4L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x40L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x8L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x140000L);
      case 116:
         if ((active0 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(2, 5, 1);
         return jjMoveStringLiteralDfa3_0(active0, 0x10800L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000L);
      case 119:
         if ((active0 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(2, 4, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(3, 8, 7);
         break;
      case 101:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 12, 7);
         else if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(3, 18, 7);
         return jjMoveStringLiteralDfa4_0(active0, 0x800L);
      case 103:
         return jjMoveStringLiteralDfa4_0(active0, 0x4L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x8L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x80240L);
      case 110:
         if ((active0 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(3, 1, 7);
         break;
      case 115:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(3, 14, 7);
         return jjMoveStringLiteralDfa4_0(active0, 0x2400L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x108000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(4, 13, 7);
         else if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(4, 19, 7);
         return jjMoveStringLiteralDfa5_0(active0, 0x100040L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x8200L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x808L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000L);
      case 115:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 7);
         break;
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x4L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x40L);
      case 99:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(5, 9, 7);
         else if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(5, 15, 7);
         break;
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x800L);
      case 103:
         if ((active0 & 0x8L) != 0L)
            return jjStartNfaWithStates_0(5, 3, 7);
         break;
      case 104:
         if ((active0 & 0x4L) != 0L)
            return jjStartNfaWithStates_0(5, 2, 7);
         break;
      case 109:
         return jjMoveStringLiteralDfa6_0(active0, 0x100000L);
      case 110:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(5, 16, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveStringLiteralDfa6_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 46:
         return jjMoveStringLiteralDfa7_0(active0, 0x100000L);
      case 110:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(6, 6, 7);
         break;
      case 115:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(6, 11, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
static private int jjMoveStringLiteralDfa7_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 111:
         return jjMoveStringLiteralDfa8_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static private int jjMoveStringLiteralDfa8_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 117:
         return jjMoveStringLiteralDfa9_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
static private int jjMoveStringLiteralDfa9_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 116:
         return jjMoveStringLiteralDfa10_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
static private int jjMoveStringLiteralDfa10_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(8, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, active0);
      return 10;
   }
   switch(curChar)
   {
      case 46:
         return jjMoveStringLiteralDfa11_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(9, active0);
}
static private int jjMoveStringLiteralDfa11_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(9, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(10, active0);
      return 11;
   }
   switch(curChar)
   {
      case 112:
         return jjMoveStringLiteralDfa12_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(10, active0);
}
static private int jjMoveStringLiteralDfa12_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(10, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(11, active0);
      return 12;
   }
   switch(curChar)
   {
      case 114:
         return jjMoveStringLiteralDfa13_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(11, active0);
}
static private int jjMoveStringLiteralDfa13_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(11, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(12, active0);
      return 13;
   }
   switch(curChar)
   {
      case 105:
         return jjMoveStringLiteralDfa14_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(12, active0);
}
static private int jjMoveStringLiteralDfa14_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(12, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(13, active0);
      return 14;
   }
   switch(curChar)
   {
      case 110:
         return jjMoveStringLiteralDfa15_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(13, active0);
}
static private int jjMoveStringLiteralDfa15_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(13, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(14, active0);
      return 15;
   }
   switch(curChar)
   {
      case 116:
         return jjMoveStringLiteralDfa16_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(14, active0);
}
static private int jjMoveStringLiteralDfa16_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(14, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(15, active0);
      return 16;
   }
   switch(curChar)
   {
      case 108:
         return jjMoveStringLiteralDfa17_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(15, active0);
}
static private int jjMoveStringLiteralDfa17_0(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(15, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(16, active0);
      return 17;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x100000L) != 0L)
            return jjStopAtPos(17, 20);
         break;
      default :
         break;
   }
   return jjStartNfa_0(16, active0);
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 20;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
               case 7:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  { jjCheckNAdd(7); }
                  break;
               case 1:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  { jjCheckNAdd(7); }
                  break;
               case 0:
                  if ((0x3ff001000000000L & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  { jjCheckNAdd(7); }
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 21)
                        kind = 21;
                     { jjCheckNAdd(5); }
                  }
                  else if (curChar == 47)
                     { jjAddStates(0, 1); }
                  else if (curChar == 36)
                  {
                     if (kind > 22)
                        kind = 22;
                     { jjCheckNAdd(7); }
                  }
                  break;
               case 5:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 21)
                     kind = 21;
                  { jjCheckNAdd(5); }
                  break;
               case 6:
                  if (curChar != 36)
                     break;
                  if (kind > 22)
                     kind = 22;
                  { jjCheckNAdd(7); }
                  break;
               case 8:
                  if (curChar == 47)
                     { jjAddStates(0, 1); }
                  break;
               case 9:
                  if (curChar == 47)
                     { jjCheckNAddStates(2, 4); }
                  break;
               case 10:
                  if ((0xffffffffffffdbffL & l) != 0L)
                     { jjCheckNAddStates(2, 4); }
                  break;
               case 11:
                  if ((0x2400L & l) != 0L && kind > 27)
                     kind = 27;
                  break;
               case 12:
                  if (curChar == 10 && kind > 27)
                     kind = 27;
                  break;
               case 13:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 12;
                  break;
               case 14:
                  if (curChar == 42)
                     { jjCheckNAddTwoStates(15, 16); }
                  break;
               case 15:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(15, 16); }
                  break;
               case 16:
                  if (curChar == 42)
                     { jjAddStates(5, 6); }
                  break;
               case 17:
                  if ((0xffff7fffffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(18, 16); }
                  break;
               case 18:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     { jjCheckNAddTwoStates(18, 16); }
                  break;
               case 19:
                  if (curChar == 47 && kind > 28)
                     kind = 28;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 22)
                        kind = 22;
                     { jjCheckNAdd(7); }
                  }
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 1:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 22)
                        kind = 22;
                     { jjCheckNAdd(7); }
                  }
                  else if (curChar == 91)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 22)
                        kind = 22;
                     { jjCheckNAdd(7); }
                  }
                  if (curChar == 116)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 4:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 22)
                        kind = 22;
                     { jjCheckNAdd(7); }
                  }
                  if (curChar == 105)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 2:
                  if (curChar == 93 && kind > 7)
                     kind = 7;
                  break;
               case 6:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  { jjCheckNAdd(7); }
                  break;
               case 7:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 22)
                     kind = 22;
                  { jjCheckNAdd(7); }
                  break;
               case 10:
                  { jjAddStates(2, 4); }
                  break;
               case 15:
                  { jjCheckNAddTwoStates(15, 16); }
                  break;
               case 17:
               case 18:
                  { jjCheckNAddTwoStates(18, 16); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 10:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(2, 4); }
                  break;
               case 15:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjCheckNAddTwoStates(15, 16); }
                  break;
               case 17:
               case 18:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjCheckNAddTwoStates(18, 16); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 20 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", "\155\141\151\156", "\154\145\156\147\164\150", 
"\123\164\162\151\156\147", "\156\145\167", "\151\156\164", "\142\157\157\154\145\141\156", null, 
"\166\157\151\144", "\160\165\142\154\151\143", "\143\154\141\163\163", 
"\145\170\164\145\156\144\163", "\164\162\165\145", "\146\141\154\163\145", "\164\150\151\163", 
"\163\164\141\164\151\143", "\162\145\164\165\162\156", "\151\146", "\145\154\163\145", 
"\167\150\151\154\145", "\123\171\163\164\145\155\56\157\165\164\56\160\162\151\156\164\154\156", null, 
null, null, null, null, null, null, null, "\173", "\50", "\133", "\135", "\51", 
"\175", "\73", "\54", "\75", "\41", "\46\46", "\174\174", "\75\75", "\41\75", "\74", 
"\76", "\74\75", "\76\75", "\53", "\55", "\52", "\174", "\56", };
static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}
static final int[] jjnextStates = {
   9, 14, 10, 11, 13, 17, 19, 
};

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         matchedToken.specialToken = specialToken;
         return matchedToken;
      }
      else
      {
         if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
         {
            matchedToken = jjFillToken();
            if (specialToken == null)
               specialToken = matchedToken;
            else
            {
               matchedToken.specialToken = specialToken;
               specialToken = (specialToken.next = matchedToken);
            }
         }
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public MiniJavaParserTokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public MiniJavaParserTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  
  static public void ReInit(SimpleCharStream stream)
  {


    jjmatchedPos =
    jjnewStateCnt =
    0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  static private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 20; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream, int lexState)
  
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public static void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }


/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, 
};
static final long[] jjtoToken = {
   0xfffffe07fffffL, 
};
static final long[] jjtoSkip = {
   0x1f800000L, 
};
static final long[] jjtoSpecial = {
   0x1f800000L, 
};
static final long[] jjtoMore = {
   0x0L, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[20];
    static private final int[] jjstateSet = new int[2 * 20];
    private static final StringBuilder jjimage = new StringBuilder();
    private static StringBuilder image = jjimage;
    private static int jjimageLen;
    private static int lengthOfMatch;
    static protected int curChar;
}
