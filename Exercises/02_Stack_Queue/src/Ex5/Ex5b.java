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
public class Ex5b {

    static int sizeQ = 0;
    static int Top = 0;

    public static void main(String[] args) {
        myQueue Q = new myQueue();

        for (int i = 0; i < 4; i++) {
            Q.enqueue(i);
        }
        Q.enqueue(2);
        System.out.println(Q);
        Top = 0;

        for (int i = 0; i < Q.size(); i++) {
            addMinToQueue(Q);
        }
        System.out.println(Q);
    }

    static void addMinToQueue(myQueue Q) {
        myQueue Temp = new myQueue();
        int min = Q.dequeue();

        while (Q.size() > Top) {
            int tmp = Q.dequeue();
            if (min <= tmp) {
                Temp.enqueue(tmp);
            } else {
                Temp.enqueue(min);
                min = tmp;
            }
        }
        Top = Top + 1;

        Q.enqueue(min);
        while (Q.size() > 0) {
            Temp.enqueue(Q.dequeue());
        }
        while (Temp.size() > 0) {
            Q.enqueue(Temp.dequeue());
        }
    }

}
