/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TREE;

import java.util.Stack;

/**
 *
 * @author duclt
 */
public class TopView {

    public static void main(String[] args) {

    }

    void top_view(Node root) {
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }

        curr = root.right;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }
}

class Node {

    int data;
    Node left;
    Node right;
}
