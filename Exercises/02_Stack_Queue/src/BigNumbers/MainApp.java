/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BigNumbers;

import java.util.Stack;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String[] args) {
        String S = "0";
        for (int i = 0; i < 99; i++) {
            S = S + 9;
        }
        BigNum NumA = new BigNum(S);
        S = "2";
//        for (int i = 0; i < 99; i++) {
//            S = S + 1;
//        }
        BigNum NumB = new BigNum(S);

        System.out.println("A: " + NumA.number);
        System.out.println("B: " + NumB.number);

        System.out.println("Sum: " + NumA.add(NumB).number);
        System.out.print("Subtract: ");
        if (BigNum.compareTo(NumA, NumB) > 0) {
            System.out.println(NumA.sub(NumB).number);
        } else if (BigNum.compareTo(NumA, NumB) < 0) {
            System.out.println("-" + NumB.sub(NumA).number);
        } else {
            System.out.println("0");
        }
        System.out.println("Multiply : " + NumB.multi(NumA).number);
        System.out.print("Division: ");
        if (BigNum.compareTo(NumA, NumB) > 0) {
            System.out.println(NumA.myDiv(NumB).number);
        } else {
            System.out.println(NumB.myDiv(NumA).number);
        }
        //System.out.println("Remainder: " + BigNum.Remainder.number);

    }
}
