/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BigNumbers;

import java.util.LinkedList;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String[] args) {
        LinkedList<Integer> NumA = new LinkedList<>();
        LinkedList<Integer> NumB = new LinkedList<>();
        LinkedList<Integer> Result = new LinkedList<>();

        for (int i = 1; i < 10; i++) {
            NumA.addLast(i % 10);
            NumB.addFirst(i % 10);
        }

        System.out.print("A: ");
        exportToString(NumA);
        System.out.print("B: ");
        exportToString(NumB);
        Calc myCal = new Calc();
        System.out.print("Sum: ");
        exportToString(myCal.addNumbers(NumA, NumB));
        System.out.print("Sub: ");
        if (myCal.compareTo(NumA, NumB) > 0) {
            exportToString(myCal.subNumbers(NumA, NumB));
        }
        if (myCal.compareTo(NumA, NumB) < 0) {
            System.out.print("-");
            exportToString(myCal.subNumbers(NumB, NumA));
        }
        System.out.print("Multiply: ");
        exportToString(myCal.multiplyNumbers(NumA, NumB));
        System.out.print("Division: ");
        exportToString(myCal.divideNumbers(NumA, NumB));
        System.out.print("Remainder: ");
        exportToString(Calc.Remainder);
    }

    static void exportToString(LinkedList<Integer> Number) {
        LinkedList<Integer> Num = new LinkedList<>();
        Num.addAll(Number);
        do {
            System.out.print(Num.removeFirst());
        } while (Num.size() > 0);
        System.out.println("");
    }
}
