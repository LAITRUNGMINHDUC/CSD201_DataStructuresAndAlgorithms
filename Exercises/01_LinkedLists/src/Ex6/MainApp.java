/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex6;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String args[]) {
        IntSLLNodeList L1 = new IntSLLNodeList();
        IntSLLNodeList L2 = new IntSLLNodeList();

        for (int i = 0; i < 10; i++) {
            L1.addToHead(i);
            L2.addToTail(i-20);
        }

        System.out.print("List 1 Original: ");
        L1.printAll();
        System.out.print("List 2 Original: ");
        L2.printAll();

        for (int i = 0; i < L2.count; i++) {
            L1.addToTail(L2.get(i));
        }

        System.out.print("Add List 2 to End of List 1: ");
        L1.printAll();
    }
}
