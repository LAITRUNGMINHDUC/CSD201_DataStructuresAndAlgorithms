/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex03_p166;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

/**
 *
 * @author duclt
 */
public class DelimiterMatching {

    private static char[] OperatorIn = {'{', '[', '('};
    private static char[] OperatorOut = {'}', ']', ')'};

    static boolean Matching(String filename) {
        Stack<Character> stack = new Stack<>();
        try {
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String Line;
            boolean comment = false;
            while ((Line = br.readLine()) != null) {
                for (int i = 0; i < Line.length(); i++) {
                    if (!comment) {
                        if (checkDelimiter(Line.charAt(i), OperatorIn)) {
                            stack.add(Line.charAt(i));
                        } else if (checkDelimiter(Line.charAt(i), OperatorOut)) {
                            char ch = stack.pop();
                            if (!checkPairDelimiter(Line.charAt(i), ch)) {
                                return false;
                            }
                        } else if (Line.charAt(i) == '/' && (i != Line.length() - 1)) {
                            if (Line.charAt(i + 1) == '*') {
                                comment = true;
                            }
                        }
                    } else if (Line.charAt(i) == '*' && (i != Line.length() - 1)) {
                        if (Line.charAt(i + 1) == '/') {
                            comment = false;
                        }
                    }
                }
            }
            if (comment) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean checkDelimiter(char c, char[] Operator) {
        for (char x : Operator) {
            if (c == x) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkPairDelimiter(char c, char in) {
        for (int i = 0; i < OperatorOut.length; i++) {
            if (c == OperatorOut[i]) {
                if (in == OperatorIn[i]) {
                    return true;
                }
            }
        }
        return false;
    }

}
