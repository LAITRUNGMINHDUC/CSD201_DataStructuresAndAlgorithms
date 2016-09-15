package Ex4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duclt
 */
public class IntSLLNode {

    public int info;
    public IntSLLNode next;

    public IntSLLNode(int i) {
        this(i, null);
    }

    public IntSLLNode(int i, IntSLLNode n) {
        info = i;
        next = n;
    }

}
