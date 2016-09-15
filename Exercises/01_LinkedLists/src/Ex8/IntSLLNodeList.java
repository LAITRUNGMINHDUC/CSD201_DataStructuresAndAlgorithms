package Ex8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author duclt
 */
public class IntSLLNodeList {

    protected IntSLLNode head, tail;
    protected int count = 0;

    public IntSLLNodeList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(int el) {
        head = new IntSLLNode(el, head);
        if (tail == null) {
            tail = head;
        }
        count++;
    }

    public void printAll() {
        for (IntSLLNode tmp = head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.info + " ");
        }
        System.out.println();
    }

    public IntSLLNode getNode(int pos) {
        IntSLLNode tmp = head;
        for (int i = 0; i < pos; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public void addToMiddle(IntSLLNode node, int pos) {
        IntSLLNode A = getNode(pos);
        IntSLLNode B = getNode(pos + 1);
        A.next = node;
        node.next = B;
    }

}
