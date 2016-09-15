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
public class MainApp {

    public static void main(String[] args) throws Exception {
        String prefix = "+ 10 3";
        String postfix = "10 3 +";
        try {
            Prefix(prefix);
        } catch (Exception e) {
            throw new Exception("Invalid expression");
        }
        System.out.println("");
        try {
            Postfix(postfix);
        } catch (Exception e) {
            throw new Exception("Invalid expression");
        }
    }

    static void Prefix(String S) throws Exception {
        System.out.println("Prefix String: " + S);
        System.out.println("Result: " + Calculator.preCalculate(S));
        System.out.println("Prefix to Postfix: " + Converter.preToPost(S));
    }

    static void Postfix(String S) throws Exception {
        System.out.println("Postfix String: " + S);
        System.out.println("Result: " + Calculator.postCalculate(S));
        System.out.println("Postfix to Prefix: " + Converter.postToPre(S));

    }
}
