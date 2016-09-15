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
public class Ex5a {

    public static void main(String[] args) {
        myQueue Q1 = new myQueue();
        myQueue Temp01 = new myQueue();
        myQueue Temp02 = new myQueue();

        for (int i = 0; i < 10; i++) {
            Q1.enqueue(i);
        }
        Q1.enqueue(2);
        Q1.enqueue(5);

        Q1.enqueue(minVal(Q1, Temp01));
        do {
            if (Temp01.isEmpty() && !Temp02.isEmpty()) {
                Q1.enqueue(minVal(Temp02, Temp01));
            }
            if (Temp02.isEmpty() && !Temp01.isEmpty()) {
                Q1.enqueue(minVal(Temp01, Temp02));
            }
            if (Temp01.isEmpty() && Temp02.isEmpty()) {
                break;
            }
        } while (true);
        System.out.println(Q1);
    }

    static int minVal(myQueue Q, myQueue Temp) {
        int min = Q.dequeue();
        if (Q.isEmpty()) {
            return min;
        }
        do {
            int tmp = Q.dequeue();
            if (min <= tmp) {
                Temp.enqueue(tmp);
            } else {
                Temp.enqueue(min);
                min = tmp;
            }
        } while (!Q.isEmpty());
        System.out.println(Temp);
        return min;
    }
}
