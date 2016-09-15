package Ex10;

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

    public int deleteFromHead() { // delete the head and return its info;
        int el = head.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } else {
            head = head.next;
        }
        count--;
        return el;
    }

    public int deleteFromTail() { // delete the tail and return its info;
        int el = tail.info;
        if (head == tail) // if only one node on the list;
        {
            head = tail = null;
        } else { // if more than one node on the list,
            IntSLLNode tmp; // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp; // the predecessor of tail becomes tail;
            tail.next = null;
        }
        count--;
        return el;
    }

    public void removeFromPos(int pos) {

        if (pos == 0) {
            deleteFromHead();
            return;
        }
        if (pos == count) {
            deleteFromTail();
            return;
        }

        IntSLLNode A = getNode(pos - 1);
        IntSLLNode C = getNode(pos + 1);
        A.next = C;
        count--;
    }

}
