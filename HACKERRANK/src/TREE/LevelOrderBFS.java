/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TREE;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author duclt
 */
public class LevelOrderBFS {

    public static void main(String[] args) {

    }

    void LevelOrder(Node root) {
        Queue<Node> qNode = new LinkedList<>();
        Node node = root;
        if (node != null) {
            qNode.add(node);
            while (!qNode.isEmpty()) {
                node = qNode.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    qNode.add(node.left);
                }
                if (node.right != null) {
                    qNode.add(node.right);
                }
            }
        }
    }

}
