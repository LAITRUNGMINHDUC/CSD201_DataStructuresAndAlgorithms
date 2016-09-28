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
public class IntBSTNode {

    protected int key;
    protected IntBSTNode left, right;

    public IntBSTNode() {
        left = right = null;
    }

    public IntBSTNode(int el) {
        this(el, null, null);
    }

    public IntBSTNode(int el, IntBSTNode lt, IntBSTNode rt) {
        key = el;
        left = lt;
        right = rt;
    }
}
