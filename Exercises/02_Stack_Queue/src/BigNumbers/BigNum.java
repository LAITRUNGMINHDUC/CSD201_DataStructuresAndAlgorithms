/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BigNumbers;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author duclt
 */
public class BigNum {

    public String number;
    static BigNum Remainder = new BigNum("0");

    public BigNum(String number) {
        this.number = number;
    }

    public String stackToString(Stack<Integer> stack) {
        String s = "";
        while (!stack.isEmpty()) {
            s += stack.pop();
        }
        return s;
    }

    public Stack<Integer> stringToStack(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            int tmp = s.charAt(i) - '0';
            stack.push(tmp);
        }
        return stack;
    }

    public BigNum add(BigNum other) {
        int a, b, sum, leftDigit;
        int carry = 0;

        Stack<Integer> numA = new Stack<>();
        Stack<Integer> numB = new Stack<>();
        Stack<Integer> Result = new Stack<>();

        numA = stringToStack(this.number);
        numB = stringToStack(other.number);

        do {
            try {
                a = numA.pop();
            } catch (Exception e) {
                a = 0;
            }
            try {
                b = numB.pop();
            } catch (Exception e) {
                b = 0;
            }
            sum = a + b + carry;
            leftDigit = sum % 10;
            carry = sum / 10;
            Result.push(leftDigit);
        } while (numA.size() > 0 || numB.size() > 0);

        if (carry > 0) {
            Result.push(carry);
        }
        return new BigNum(stackToString(Result));
    }

    public BigNum sub(BigNum other) {
        int borrow = 0;
        int a, b, sub;
        Stack<Integer> numA = new Stack<>();
        Stack<Integer> numB = new Stack<>();
        Stack<Integer> Result = new Stack<>();
        numA = stringToStack(this.number);
        numB = stringToStack(other.number);
        do {
            try {
                a = numA.pop();
            } catch (Exception e) {
                a = 0;
            }
            try {
                b = numB.pop();
            } catch (Exception e) {
                b = 0;
            }
            sub = a - b - borrow;
            if (sub < 0) {
                sub = sub + 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            Result.push(sub);
        } while (numA.size() > 0 || numB.size() > 0);
        return new BigNum(stackToString(Result));
    }

    public BigNum multi(BigNum other) {
        int pos = -1;
        Stack<Integer> numA = new Stack<>();

        numA = stringToStack(this.number);
        BigNum Result = new BigNum("0");
        do {
            pos = pos + 1;

            int numPos = numA.pop();
            BigNum TempNum = new BigNum("0");
            for (int j = 0; j < numPos; j++) {
                TempNum = TempNum.add(other);
            }
            for (int j = 0; j < pos; j++) {
                TempNum.number = TempNum.number + "0";
            }
            Result = Result.add(TempNum);
        } while (numA.size() > 0);
        return Result;
    }

    public BigNum div(BigNum other) {
        boolean isZero = false;

        BigNum numA = new BigNum(this.number);
        BigNum Result = new BigNum("0");
        BigNum One = new BigNum("1");

        do {
            numA = numA.sub(other);
            Result = Result.add(One);
        } while (compareTo(numA, other) >= 0);
        Remainder = numA;
        return Result;
    }

    public BigNum myDiv(BigNum other) {
        BigNum numA = new BigNum(this.number);
        BigNum Ten = new BigNum("10000");
        BigNum One = new BigNum("1");

        Stack<BigNum> Result = new Stack<>();

        do {
            BigNum Temp = other;
            BigNum Temp01 = new BigNum("0");
            while (compareTo(numA, Temp) > 0) {
                Temp01 = Temp;
                if (compareTo(numA, Temp) > 0) {
                    Temp = Temp.multi(Ten);
                }
            }
            Temp.number = "0";
            do {
                numA = numA.sub(Temp01);
                Temp = Temp.add(One);
            } while (compareTo(numA, Temp01) >= 0);
            Result.push(Temp);
        } while (compareTo(numA, other) >= 0);

        String S = "";
        do {
            S = Result.pop().number + S;
        } while (Result.size() > 0);
        return new BigNum(S);
    }

    public static int compareTo(BigNum A, BigNum B) {
        while (A.number.length() > B.number.length()) {
            B.number = "0" + B.number;
        }
        while (A.number.length() < B.number.length()) {
            A.number = "0" + A.number;
        }

        if (A.number.compareTo(B.number) > 0) {
            return 1;
        }
        if (A.number.compareTo(B.number) < 0) {
            return -1;
        }
        return 0;

//        for (int i = 0; i < A.number.length(); i++) {
//            char a = A.number.charAt(i);
//            char b = B.number.charAt(i);
//            if (a > b) {
//                return 1;
//            }
//            if (a < b) {
//                return -1;
//            }
//        }
//        return 0;
    }
}
