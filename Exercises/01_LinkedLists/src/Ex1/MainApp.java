/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String args[]) {
        IntSLLNodeList Num1 = new IntSLLNodeList();
        IntSLLNodeList Num2 = new IntSLLNodeList();
        IntSLLNodeList Result = new IntSLLNodeList();

        Num1.addToTail(5);
        Num1.addToTail(6);
        Num1.addToTail(3);
        int a = Num1.convertInt();
        System.out.print("First number: ");
        Num1.printAll();

        Num2.addToTail(5);
        Num2.addToTail(6);
        Num2.addToTail(3);
        int b = Num1.convertInt();
        System.out.print("Second number: ");
        Num2.printAll();

        int c = a + b;
        do {
            Result.addToTail(c % 10);
            c = c / 10;
        } while (c > 0);

        System.out.print("Result number: ");
        Result.printAll();
    }
}
