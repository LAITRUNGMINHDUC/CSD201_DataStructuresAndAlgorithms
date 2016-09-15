/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex5;

/**
 *
 * @author duclt
 */
public class MainApp {

    static IntSLLNodeList L = new IntSLLNodeList();

    public static void main(String args[]) {

        for (int i = 0; i < 10; i++) {
            L.addToHead(i);
        }
        System.out.print("Original list: ");
        L.printAll();

        System.out.print("Reverse list: ");
        L.reverseList();
        L.printAll();

    }
}
