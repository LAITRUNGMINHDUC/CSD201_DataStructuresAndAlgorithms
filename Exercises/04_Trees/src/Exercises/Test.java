/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises;

/**
 *
 * @author duclt
 */
class Test {

    public static void main(String[] args) {
        IntBST tree = new IntBST();

        String S = "50 30 80 20 40 70 100 120 90 10 1 4";
        //String S = "1 2 3 4 5 6 7 9 8 10";
        String[] arr = S.split(" ");
        for (String x : arr) {
            tree.Insert(Integer.parseInt(x));
        }
        
        System.out.print("Tree: ");
        tree.BreathFirst();
        System.out.println("");
        System.out.println("*** Using recursive ***");
        System.out.println("2a - Count node: " + tree.CountNode(tree.root));
        System.out.println("2b - Count leaves: " + tree.CountLeaves(tree.root));
        System.out.println("2c - Count Right Children: " + tree.CountRightChildren(tree.root));
        System.out.println("2d - Find Height: " + tree.findHeight(tree.root));
        System.out.print("2e - Delete leaves: ");
        tree.deleteLeaves(tree.root, tree.root);
        tree.BreathFirst();

        System.out.println("");
        System.out.println("");
        System.out.println("*** Using non-recursive ***");
        tree.clear();
        for (String x : arr) {
            tree.Insert(Integer.parseInt(x));
        }
        System.out.println("2a - Count node: " + tree.CountNode());
        System.out.println("2b - Count leaves: " + tree.CountLeaves());
        System.out.println("2c - Count Right Children: " + tree.CountRightChildren());
        System.out.println("2d - Find Height: " + tree.findHeight());
        System.out.print("2e - Delete leaves: ");
        tree.deleteLeaves();
        tree.BreathFirst();
    }
}
