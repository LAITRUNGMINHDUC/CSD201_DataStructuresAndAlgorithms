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
public class StringMingling {

    public static void main(String[] args) {
        String a = "h a c k e r";
        String b = "r a n k e r";
        System.out.println(strMingling(a, b));
    }

    public static String strMingling(String a, String b) {
        if (a.length() == 1) {
            return a + b;
        }
        return strMingling(a.charAt(0) + "", b.charAt(0) + "") 
                + strMingling(a.substring(1), b.substring(1));
    }
}
