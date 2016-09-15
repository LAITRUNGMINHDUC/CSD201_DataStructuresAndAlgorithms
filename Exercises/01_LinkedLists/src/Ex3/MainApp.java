/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

/**
 *
 * @author duclt
 */
public class MainApp {

    static IntSLLNodeList L1 = new IntSLLNodeList();
    static IntSLLNodeList L2 = new IntSLLNodeList();
    static IntSLLNodeList L3 = new IntSLLNodeList();

    public static void main(String args[]) {
        int list1[] = {1, 3, 4, 5, 7};
        int list2[] = {2, 3, 5, 6};

        for (int x : list1) {
            L1.addToHead(x);
        }
        for (int x : list2) {
            L2.addToHead(x);
        }

        Intersection();
        L3.printAll();
        System.out.println();
        Union();
        L1.printAll();
    }

    static void Intersection() {
        for (int i = 0; i < L1.count; i++) {
            for (int j = 0; j < L2.count; j++) {
                if (L1.getNode(i).info == L2.getNode(j).info) {
                    if (!L3.isInList(L2.getNode(j).info)) {
                        L3.addToHead(L2.getNode(j).info);
                    }
                }
            }
        }
    }

    static void Union() {
        for (int i = 0; i < L2.count; i++) {
            if (!L1.isInList(L2.getNode(i).info)) {
                L1.addToTail(L2.getNode(i).info);
            }
        }
    }
}
