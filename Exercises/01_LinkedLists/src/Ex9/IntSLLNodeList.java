package Ex9;

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

    public void addToTail(int el) {
        if (!isEmpty()) {
            tail.next = new IntSLLNode(el);
            tail = tail.next;
        } else {
            head = tail = new IntSLLNode(el);
        }

        count++;
    }

    public void addToPos(IntSLLNode node, int pos) {
        if (pos == 0) {
            addToHead(node.info);
            return;
        }
        if (pos == count) {
            addToTail(node.info);
            return;
        }
        IntSLLNode A = getNode(pos - 1);
        IntSLLNode B = getNode(pos);
        A.next = node;
        node.next = B;
        count++;
    }

}
