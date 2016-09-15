/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Ex2;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(Harmonic(n));
    }

    static double Harmonic(int n) {
        if (n == 1) {
            return 1;
        } else {
            return Harmonic(n) + 1 / (n - 1);
        }
    }
}
