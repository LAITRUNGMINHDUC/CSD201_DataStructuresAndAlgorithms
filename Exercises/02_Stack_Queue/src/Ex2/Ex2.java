/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import java.util.Stack;

/**
 *
 * @author duclt
 */
public class Ex2 {

    public static void main(String[] args) {
        Stack<Integer> S1 = new Stack<>();
        Stack<Integer> Temp = new Stack<>();
        int TempNum;

        S1.push(1);
        S1.push(5);
        S1.push(3);

        int Element = 6;

        do {
            TempNum = S1.pop();
            Temp.push(TempNum);
        } while (Element < TempNum);

        S1.push(Temp.pop());
        S1.push(Element);

        do {
            S1.push(Temp.pop());
        } while (Temp.size() > 0);
        if (Element >= TempNum) {
        }

        System.out.println(S1);
    }
}
