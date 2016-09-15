/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;

        IntSLLNodeList l = new IntSLLNodeList();

        for (int i = 0; i < arr.length; i++) {
            if (i % k == 0) {
                l.printAll();
                l.head = l.tail = null;
                l.addToHead(arr[i]);
            } else {
                l.addToHead(arr[i]);
            }
        }
        l.printAll();
    }
}
