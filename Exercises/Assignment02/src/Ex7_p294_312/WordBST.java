/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7_p294_312;

/**
 *
 * @author duclt
 */
public class WordBST {

    WordBSTNode root;

    public WordBST() {
        this.root = null;
    }

    public void clear() {
        this.root = null;
    }

    public WordBSTNode findWordPos(WordBSTNode p, String el) {
        if (p != null) {
            int val = p.data.compareTo(el);
            if (val < 0) {
                return findWordPos(p.right, el);
            }
            if (val == 0) {
                return p;
            }
            if (val > 0) {
                return findWordPos(p.left, el);
            }
        }
        return null;
    }

    public void insertWordNode(String el, String latin) {
        WordBSTNode p = root;
        WordBSTNode parent = null;

        while (p != null) {
            parent = p;
            int val = p.data.compareTo(el);
            if (val > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        if (root == null) {
            root = new WordBSTNode(el, null, null, latin);
        } else {
            int val = parent.data.compareTo(el);
            if (val > 0) {
                parent.left = new WordBSTNode(el, null, null, latin);
            } else {
                parent.right = new WordBSTNode(el, null, null, latin);
            }
        }
    }

    //Using Inorder-traversal
    public void traversalTree(WordBSTNode p) {
        if (p != null) {
            traversalTree(p.left);
            System.out.println(p.manualToString());
            traversalTree(p.right);
        }
    }
}
