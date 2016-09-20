/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Traversal;

/**
 *
 * @author duclt
 */
public class CountLeaves {

    static int i = 0;

    static void countLeaves(Node node) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                i = i + 1;
            }
            countLeaves(node.left);
            countLeaves(node.right);
        }
    }

    class Node {

        int data;
        Node left;
        Node right;
    }
}
