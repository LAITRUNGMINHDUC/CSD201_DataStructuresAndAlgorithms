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
public class Calc {

    static LinkedList<Integer> Remainder = new LinkedList<>();

    public LinkedList<Integer> addNumbers(LinkedList<Integer> Num1, LinkedList<Integer> Num2) {
        int carry = 0;
        int a, b, sum, leftDigit;
        LinkedList<Integer> BigNum = new LinkedList<>();
        LinkedList<Integer> numA = new LinkedList<>();
        LinkedList<Integer> numB = new LinkedList<>();
        numA.addAll(Num1);
        numB.addAll(Num2);

        while (numA.size() > numB.size()) {
            numB.addFirst(0);
        }

        while (numA.size() < numB.size()) {
            numA.addFirst(0);
        }


        do {
            a = numA.removeLast();
            b = numB.removeLast();

            sum = a + b + carry;
            carry = sum / 10;
            leftDigit = sum % 10;
            BigNum.addFirst(leftDigit);
        } while (numA.size() > 0);

        if (carry > 0) {
            BigNum.addFirst(1);
        }
        return BigNum;
    }

    public LinkedList<Integer> subNumbers(LinkedList<Integer> Num1, LinkedList<Integer> Num2) {
        int borrow = 0;
        int a, b, sub;
        LinkedList<Integer> BigNum = new LinkedList<>();
        LinkedList<Integer> numA = new LinkedList<>();
        LinkedList<Integer> numB = new LinkedList<>();
        numA.addAll(Num1);
        numB.addAll(Num2);

        while (numA.size() > numB.size()) {
            numB.addFirst(0);
        }

        while (numA.size() < numB.size()) {
            numA.addFirst(0);
        }

        do {
            a = numA.removeLast();
            b = numB.removeLast();

            sub = a - b - borrow;
            if (sub < 0) {
                sub = sub + 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            BigNum.addFirst(sub);
        } while (numA.size() > 0);

        while (BigNum.size() > 0 && BigNum.getFirst() == 0) {
            BigNum.removeFirst();
        }
        return BigNum;
    }

    public LinkedList<Integer> multiplyNumbers(LinkedList<Integer> Num1, LinkedList<Integer> Num2) {
        int pos = -1;
        LinkedList<Integer> BigNum = new LinkedList<>();
        LinkedList<Integer> Temp = new LinkedList<>();
        LinkedList<Integer> numA = new LinkedList<>();
        LinkedList<Integer> numB = new LinkedList<>();
        numA.addAll(Num1);
        numB.addAll(Num2);
        while (numA.size() > numB.size()) {
            numB.addFirst(0);
        }

        while (numA.size() < numB.size()) {
            numA.addFirst(0);
        }

        for (int i = numA.size(); i > 0; i--) {
            pos = pos + 1;
            Temp.clear();
            Temp.addFirst(0);
            int numPos = numA.get(i - 1);
            for (int j = 0; j < numPos; j++) {
                Temp = addNumbers(Temp, numB);
            }
            for (int j = 0; j < pos; j++) {
                Temp.addLast(0);
            }
            BigNum = addNumbers(Temp, BigNum);
        }
        return BigNum;
    }

    public LinkedList<Integer> divideNumbers(LinkedList<Integer> Num1, LinkedList<Integer> Num2) {
        LinkedList<Integer> BigNum = new LinkedList<>();
        LinkedList<Integer> Temp = new LinkedList<>();
        LinkedList<Integer> numA = new LinkedList<>();
        LinkedList<Integer> numB = new LinkedList<>();
        numA.addAll(Num1);
        numB.addAll(Num2);
        BigNum.addFirst(0);
        Temp.addFirst(1);
        while (numA.size() > numB.size()) {
            numB.addFirst(0);
        }
        while (numA.size() < numB.size()) {
            numA.addFirst(0);
        }

        do {
            numA = subNumbers(numA, numB);
            BigNum = addNumbers(BigNum, Temp);
        } while (compareTo(numA, numB) >= 0);
        Remainder = numA;
        return BigNum;
    }

    public int compareTo(LinkedList<Integer> numA, LinkedList<Integer> numB) {
        LinkedList<Integer> Num1 = new LinkedList<>();
        LinkedList<Integer> Num2 = new LinkedList<>();
        Num1.addAll(numA);
        Num2.addAll(numB);

        while (Num1.size() > 0 && Num1.getFirst() == 0) {
            Num1.removeFirst();
        }
        while (Num2.size() > 0 && Num2.getFirst() == 0) {
            Num2.removeFirst();
        }

        if (Num1.size() > Num2.size()) {
            return 1;
        }
        if (Num1.size() < Num2.size()) {
            return -1;
        }

        do {
            int a = Num1.removeFirst();
            int b = Num2.removeFirst();
            if (a > b) {
                return 1;
            }
            if (a < b) {
                return -1;
            }
        } while (Num1.size() > 0);
        return 0;
    }
}
