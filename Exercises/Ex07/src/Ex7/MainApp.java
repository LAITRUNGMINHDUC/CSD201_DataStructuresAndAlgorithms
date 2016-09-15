/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7;

/**
 *
 * @author duclt
 */
public class MainApp {

    static IntSLLNodeList L = new IntSLLNodeList();

    public static void main(String args[]) {

        int value = 10;
        for (int i = 0; i < 10; i++) {
            L.addToTail(i);
        }
        System.out.print("Original Sorted list: ");        
        L.addToTail(100);
        L.printAll();
        System.out.print("Insert in Sorted list: ");        
        insertNode(value);
        L.printAll();
    }

    static void insertNode(int value) {
        IntSLLNode A = new IntSLLNode(value);
        IntSLLNode B = new IntSLLNode();
        IntSLLNode C = new IntSLLNode();
        for (int i = 0; i < L.count; i++) {
            if (value < L.get(i).info) {
                B = L.get(i);
                C = L.get(i - 1);
                break;
            }
        }

        C.next = A;
        A.next = B;
    }

}
