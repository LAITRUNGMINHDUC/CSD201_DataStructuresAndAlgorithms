/*
 * To change this license header choose License Headers in Project Properties.
 * To change this template file choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author duclt
 */
public class Bai2 {

    LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        String S = "3 7 5 20 -10 0 12";
        int k = 2;
        Scanner sc = new Scanner(System.in);

        System.out.println("String: ");
        S = sc.nextLine();
        System.out.println("K: ");
        k = sc.nextInt();

        Bai2 B2 = new Bai2();
        B2.input(S);
        B2.process(k);
    }

    public void input(String S) {
        String[] myS = S.split(" ");
        for (String x : myS) {
            list.add(Integer.parseInt(x));
        }
    }

    public double sumAll() {
        double sum = 0.0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i);
        }
        return sum;
    }

    public void process(int k) {
        // int size = list.size();
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        double avg = 0.0;
        double avg2 = sumAll();

        for (int i = 0; i < list.size(); i++) {
            if (i % k == 0) {
                avg = avg / 3;
                if (avg <= avg2 && (list1.size() == k)) {
                    avg2 = avg;
                    list2.clear();
                    for (int j = 0; j < k; j++) {
                        list2.add(list1.get(j));
                    }
                }
                list1.clear();
                list1.add(list.get(i));
                avg = 0;
                avg = avg + list.get(i);
            } else {
                list1.add(list.get(i));
                avg = avg + list.get(i);
            }
        }

        System.out.println("");
        System.out.println("Output: ");
        for (int i = 0; i < k; i++) {
            System.out.print(list2.get(i) + " ");
        }
        System.out.println("Avg = " + avg2);
    }
}
