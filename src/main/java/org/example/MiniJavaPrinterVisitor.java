package org.example;

public class MiniJavaPrinterVisitor extends MiniJavaParserDefaultVisitor {
    public Object print(SimpleNode node, Object data) {
        Token t = node.jjtGetFirstToken();

        while (t != node.jjtGetLastToken()) {
            t = t.next;
            print(t);
        }
        return data;
    }


    protected void print(Token t) {
        if(t == null) {
            return;
        }
        Token tt = t.specialToken;
        if (tt != null) {
            while (tt.specialToken != null) tt = tt.specialToken;
            while (tt != null) {
                System.out.print(addUnicodeEscapes(tt.image));
                tt = tt.next;
            }
        }
        System.out.print(addUnicodeEscapes(t.image));
    }


    private String addUnicodeEscapes(String str) {
        String retval = "";
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if ((ch < 0x20 || ch > 0x7e) &&
                    ch != '\t' && ch != '\n' && ch != '\r' && ch != '\f') {
                String s = "0000" + Integer.toString(ch, 16);
                retval += "\\u" + s.substring(s.length() - 4, s.length());
            } else {
                retval += ch;
            }
        }
        return retval;
    }

    @Override
    public Object defaultVisit(SimpleNode node, Object data) {
        return print(node, data);
    }
}