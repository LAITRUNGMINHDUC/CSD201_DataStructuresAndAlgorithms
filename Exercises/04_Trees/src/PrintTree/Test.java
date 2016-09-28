/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrintTree;

/**
 *
 * @author duclt
 */
public class Test {

    public static void main(String[] args) {
        IntBST tree = new IntBST();
        String S = "50 30 80 20 40 70 100 120 90 10 15";
        
        //String S = "50";
        String[] arr = S.split(" ");
        for (String x : arr) {
            tree.Insert(Integer.parseInt(x));
        }
        System.out.println("Print Rotation left: ");
        tree.printRotationLeftByInorder(tree.root, 0, tree.findHeight(tree.root));
        System.out.println("Print Normal:");
        tree.printTreeByBFS(tree.findHeight(tree.root));
        System.out.println("");
    }
}
