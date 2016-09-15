/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrePost;

/**
 *
 * @author duclt
 */
import java.util.Stack;

public class Converter {

    static boolean isOperator(String S) {
        String[] Operator = {"+", "-", "*", "/"};
        for (int i = 0; i < Operator.length; i++) {
            if (Operator[i].equals(S)) {
                return true;
            }
        }
        return false;
    }

    public static String preToPost(String prefix) throws Exception {
        Stack<String> Temp = new Stack<>();
        String[] arr = prefix.split(" ");

        for (int i = arr.length - 1; i >= 0; i--) {
            if (isOperator(arr[i])) {
                try {
                    String x = Temp.pop();
                    String y = Temp.pop();
                    String result = x + " " + y + " " + arr[i];
                    Temp.push(result);
                } catch (Exception e) {
                    throw new Exception("Invalid Expression");
                }
            } else {
                Temp.push(arr[i]);
            }
        }
        return Temp.pop();
    }

    public static String postToPre(String postfix) throws Exception {
        Stack<String> Temp = new Stack<>();
        String[] arr = postfix.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (isOperator(arr[i])) {
                try {
                    String x = Temp.pop();
                    String y = Temp.pop();
                    String result = arr[i] + " " + y + " " + x;
                    Temp.push(result);
                } catch (Exception e) {
                    throw new Exception("Invalid expression");
                }
            } else {
                Temp.push(arr[i]);
            }
        }
        return Temp.pop();

    }

}
