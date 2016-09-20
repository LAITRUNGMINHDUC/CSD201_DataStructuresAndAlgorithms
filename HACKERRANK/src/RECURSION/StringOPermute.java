/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RECURSION;

/**
 *
 * @author duclt
 */
public class StringOPermute {

    public static void main(String[] args) {
        String S = "123456";
        System.out.println(StringOPermute(S));
        
    }

    public static String StringOPermute(String S) {
        if (S.length() == 2) {
            return "" + S.charAt(1) + S.charAt(0);
        }
        if (S.length() > 2) {
            return StringOPermute(S.substring(0, 2))
                    + StringOPermute(S.substring(2));
        }
        return "";
    }

}
