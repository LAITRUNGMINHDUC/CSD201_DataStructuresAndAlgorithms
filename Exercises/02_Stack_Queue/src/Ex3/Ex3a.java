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
public class Ex3a {

    public static void main(String[] args) {
        Stack<Integer> S1 = new Stack<>();
        Stack<Integer> S2 = new Stack<>();
        Stack<Integer> Temp = new Stack<>();

        for (int i = 0; i < 10; i++) {
            S1.push(i);
        }
        do {
            Temp.push(S1.pop());
        } while (S1.size() > 0);

        do {
            S2.push(Temp.pop());
        } while (Temp.size() > 0);

        System.out.println(S2.toString());
    }
}
