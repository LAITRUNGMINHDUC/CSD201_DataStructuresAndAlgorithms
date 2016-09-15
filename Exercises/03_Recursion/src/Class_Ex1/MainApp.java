/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class_Ex1;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        System.out.println(powerX(2, 5));
    }

    static int powerX(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * powerX(x, n - 1);
        }
    }
}
