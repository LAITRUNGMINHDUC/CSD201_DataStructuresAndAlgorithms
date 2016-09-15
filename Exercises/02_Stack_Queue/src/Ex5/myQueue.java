/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex5;

/**
 *
 * @author duclt
 */
public class myQueue {

    private java.util.LinkedList<Integer> list = new java.util.LinkedList<>();

    public myQueue() {
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int firstEl() {
        return list.getFirst();
    }

    public int dequeue() {
        return list.removeFirst();
    }

    public void enqueue(int el) {
        list.addLast(el);
    }

    public String toString() {
        return list.toString();
    }

    public int size() {
        return list.size();
    }
}
