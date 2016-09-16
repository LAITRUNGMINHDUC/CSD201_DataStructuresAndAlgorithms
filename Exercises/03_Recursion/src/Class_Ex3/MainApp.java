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
        int N = 1000000000;
        System.out.println(cutZero(addDelimiter(N)));
    }

    /**
     * Method to add delimiter to separate String number by 3-digits
     *
     * @return String
     * @param S
     */
    static String addDelimiter(String S) {
        if (S.length() < 4) {
            return S;
        }
        return addDelimiter(S.substring(0, S.length() - 3)) + "." + S.substring(S.length() - 3, S.length());
    }

    /**
     * Method to add delimiter to separate Integer number by 3-digits
     *
     * @return String
     * @param S
     */
    static String addDelimiter(int N) {
        if (N % 1000 == N) {
            if (N >= 0 && N <= 9) {
                return "00" + Integer.toString(N);
            }
            if (N >= 10 && N <= 99) {
                return "0" + Integer.toString(N);
            }
            return "" + Integer.toString(N);
        }
        return addDelimiter(N / 1000) + "." + addDelimiter(N % 1000);
    }

    static String cutZero(String S) {
        int len = S.length();
        int k = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '0') {
                k = i;
                break;
            }
        }
        return S.substring(k, len);
    }
}
