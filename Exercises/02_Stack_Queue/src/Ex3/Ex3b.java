/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

import java.util.Stack;

/**
 *
 * @author duclt
 */
public class Ex3b {

    public static void main(String[] args) {
        Stack<Integer> S1 = new Stack<>();
        Stack<Integer> S2 = new Stack<>();
        for (int i = 0; i < 10; i++) {
            S1.push(i);
        }

        int Top = 0;
        int Temp = 0;

        int size = S1.size();
        while (Top <= size) {
            Temp = S1.pop();
            do {
                S2.push(S1.pop());
            } while (S1.size() > Top);
            S1.push(Temp);
            do {
                S1.push(S2.pop());
            } while (S2.size() > 0);
            Top = Top + 1;
        }

        do {
            S2.push(S1.pop());
        } while (S1.size() > 0);

        System.out.println(S2.toString());
    }

}
