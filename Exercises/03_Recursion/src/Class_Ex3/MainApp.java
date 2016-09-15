/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Ex3;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String[] args) {
        String S = "123456789";
        System.out.println(addDelimiter(S));
    }

    static String addDelimiter(String S) {
        if (S.length() < 4) {
            return S;
        }
        return addDelimiter(S.substring(0, S.length() - 3)) + "." +  S.substring(S.length() - 3, S.length());
    }
}
