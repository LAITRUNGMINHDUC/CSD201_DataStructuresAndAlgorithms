/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex8;

/**
 *
 * @author duclt
 */
public class MainApp {

    static IntSLLNodeList L = new IntSLLNodeList();

    public static void main(String args[]) {
        for (int i = 0; i < 9; i++) {
            L.addToHead(i);
        }
        int value = 10;
        IntSLLNode node = new IntSLLNode(value);

        int pos = L.count;
        if (pos % 2 == 0) {
            L.addToMiddle(node, pos / 2 - 1);
        } else {
            L.addToMiddle(node, pos / 2);
        }

        L.printAll();
    }
}
