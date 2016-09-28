/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreesTxtBook;

/**
 *
 * @author duclt
 */
public class IntBST {

    protected IntBSTNode root;

    public IntBST() {
        root = null;
    }

    protected void visit(IntBSTNode p) {
        System.out.print(p.key + " ");
    }

    protected void insert(int el) {
        IntBSTNode p = root, prev = null;
        while (p != null) {
            prev = p;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (root == null) {
            root = new IntBSTNode(el);
        } else if (prev.key < el) {
            prev.right = new IntBSTNode(el);
        } else {
            prev.left = new IntBSTNode(el);
        }
    }
    
    protected int CountNode(IntBSTNode p) {
        if (p != null) {
            
        }
    }
}
