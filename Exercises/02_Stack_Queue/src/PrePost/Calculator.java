/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrePost;

import java.util.Stack;

/**
 *
 * @author duclt
 */
public class Calculator {

    private static boolean isOperator(String S) {
        String[] Operator = {"+", "-", "*", "/"};
        for (int i = 0; i < Operator.length; i++) {
            if (Operator[i].equals(S)) {
                return true;
            }
        }
        return false;
    }

    private static int Calculate(int A, int B, String S) {
        if (S.equals("+")) {
            return A + B;
        }
        if (S.equals("-")) {
            return A - B;
        }
        if (S.equals("*")) {
            return A * B;
        }
        if (S.equals("/")) {
            return A / B;
        }
        return Integer.MIN_VALUE;
    }

    public static int postCalculate(String postfix) throws Exception {
        Stack<Integer> Temp = new Stack<>();
        String[] arr = postfix.split(" ");

        for (int i = 0; i < arr.length; i++) {
            if (!isOperator(arr[i])) {
                Temp.push(Integer.parseInt(arr[i]));
            } else {
                try {
                    int x = Temp.pop();
                    int y = Temp.pop();
                    int Result = Calculate(y, x, arr[i]);
                    Temp.push(Result);
                } catch (Exception e) {
                    throw new Exception("Invalid Expression");
                }
            }
        }
        return Temp.pop();
    }

    public static int preCalculate(String prefix) throws Exception {
        Stack<Integer> Temp = new Stack<>();
        String[] arr = prefix.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!isOperator(arr[i])) {
                Temp.push(Integer.parseInt(arr[i]));
            } else {
                try {
                    int x = Temp.pop();
                    int y = Temp.pop();
                    int Result = Calculate(x, y, arr[i]);
                    Temp.push(Result);
                } catch (Exception e) {
                    throw new Exception("Invalid Expression");
                }
            }
        }
        return Temp.pop();
    }

}
