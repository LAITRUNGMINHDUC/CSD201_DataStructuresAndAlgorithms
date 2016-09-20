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
public class PascalTriangle {

    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(Pascal(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int Pascal(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        } else {
            return Pascal(n - 1, r - 1) + Pascal(n - 1, r);
        }
    }
}
