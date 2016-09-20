/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RECURSION;

import java.util.Scanner;

/**
 *
 * @author duclt
 */
public class GCD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(GCD(a, b));
    }

    public static int GCD(int a, int b) {
        if (a > b) {
            return GCD(a - b, b);
        }
        if (a < b) {
            return GCD(a, b - a);
        }
        return a;
    }
}
