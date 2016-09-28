/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex04_p211;

/**
 *
 * @author duclt
 */
public class NewFormat {

    private static int findPos(String S) {
        int Type01 = S.indexOf(";");
        int Type02 = S.indexOf("{");
        int Type03 = S.indexOf("}");

        if (Type01 > -1 && Type02 > -1 && Type03 > -1) {
            return Math.min(Math.min(Type01, Type02), Type03);
        }
        if (Type01 > -1 && Type02 > -1) {
            return Math.min(Type01, Type02);
        }
        if (Type02 > -1 && Type03 > -1) {
            return Math.min(Type03, Type02);
        }
        if (Type01 > -1 && Type03 > -1) {
            return Math.min(Type01, Type03);
        }
        if (Type01 > -1) {
            return Type01;
        }
        if (Type02 > -1) {
            return Type02;
        }
        if (Type03 > -1) {
            return Type03;
        }
        return 0;
    }

    private static String CharProceedString(String S, char c, int level, String tab) {
        int minPos = findPos(S);
        try {
            if (S.charAt(minPos) == c) {
                String Tmp = tab + S.substring(0, minPos + 1) + "\n";
                return Tmp + Pretty(S.substring(minPos + 1).trim(), level);
            }
        } catch (Exception e) {
        }
        return "";
    }

    private static int findPosParenthesis(String S) {
        int count = 0;
        boolean flag = false;
        if (S.contains("if")) {
            for (int i = S.indexOf("("); i < S.length(); i++) {
                if (count == 0 && flag) {
                    return i - 1;
                }
                if (S.charAt(i) == '(') {
                    count++;
                    flag = true;
                }
                if (S.charAt(i) == ')') {
                    count--;
                }
            }
        }
        return -1;
    }

    private static String KeywordProceedString(String S, int level, String tab, String kw) {
        int minPos = findPos(S);
        try {
            int posTmp = S.indexOf(kw);
            if (posTmp >= 0 && posTmp > S.indexOf("{") && posTmp <= minPos) {
                int pos = findPosParenthesis(S);
                if (pos < 0 || kw.equals("else")) {
                    pos = minPos;
                }
                String Tmp = tab + S.substring(0, pos + 1) + "\n";
                return Tmp + Pretty(S.substring(pos + 1).trim(), level);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String Pretty(String S, int level) {
        String tab = "";
        String Tmp = "";
        for (int i = 0; i < level - 1; i++) {
            tab += "\t";
        }
///////////////////////////////////////////////////////////////////////
        Tmp = KeywordProceedString(S, level + 1, tab, "if");
        if (!Tmp.equals("")) {
            return Tmp;
        }
        Tmp = KeywordProceedString(S, level - 1, tab.replaceFirst("\\t", ""), "else");
        if (!Tmp.equals("")) {
            return Tmp;
        }
////////////////////////////////////////////////////////////////////////////////
        Tmp = CharProceedString(S, '{', level + 1, tab);
        if (!Tmp.equals("")) {
            return Tmp;
        }
        Tmp = CharProceedString(S, ';', level, tab);
        if (!Tmp.equals("")) {
            return Tmp;
        }
        Tmp = CharProceedString(S, '}', level - 1, tab.replaceFirst("\\t", ""));
        if (!Tmp.equals("")) {
            return Tmp;
        }
        return tab + S.substring(0);
    }

//    public static String Pretty(String S, int level) {
//        String tab = "";
//        for (int i = 0; i < level - 1; i++) {
//            tab += "\t";
//        }
//
//        int minPos;
//
//        minPos = findPos(S);
//        ///////////////////////////////////////////////////////////////////////
//        try {
//            int posTmp = S.indexOf("if");
//            if (posTmp >= 0 && posTmp > S.indexOf("{") && posTmp <= minPos) {
//                int pos = S.indexOf(")");
//                String Tmp = tab + S.substring(0, pos + 1) + "\n";
//                return Tmp + Pretty(S.substring(pos + 1).trim(), level + 1);
//            }
//        } catch (Exception e) {
//        }
//
//        try {
//            int posTmp = S.indexOf("else");
//            if (posTmp >= 0 && posTmp <= minPos && posTmp > S.indexOf("{")) {
//                String Tmp = tab.replaceFirst("\\t", "") + S.substring(0, minPos + 1) + "\n";
//                return Tmp + Pretty(S.substring(minPos + 1).trim(), level - 1);
//            }
//        } catch (Exception e) {
//        }
//        /////////////////////////////////////////////////////////////////////////////////////    
//        try {
//            if (S.charAt(minPos) == '{') {
//                String Tmp = tab + S.substring(0, minPos + 1) + "\n";
//                return Tmp + Pretty(S.substring(minPos + 1).trim(), level + 1);
//            }
//        } catch (Exception e) {
//        }
//        try {
//            if (S.charAt(minPos) == ';') {
//                String Tmp = tab + S.substring(0, minPos + 1) + "\n";
//                return Tmp + Pretty(S.substring(minPos + 1).trim(), level);
//            }
//        } catch (Exception e) {
//        }
//        try {
//            if (S.charAt(minPos) == '}') {
//                String Tmp = tab.replaceFirst("\\t", "") + S.substring(0, minPos + 1) + "\n";
//                return Tmp + Pretty(S.substring(minPos + 1).trim(), level - 1);
//            }
//        } catch (Exception e) {
//        }
//        ////////////////////////////////////////////////////////////////////////
//        return tab + S.substring(0);
//    }
}
