/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author duclt
 */
public class Bai1 {

    LinkedList<Integer> list1 = new LinkedList<>();
    LinkedList<Integer> list2 = new LinkedList<>();

    public static void main(String[] args) {
        String S2 = "2 3 4 5 6";
        String S1 = "2 3 4 5";

        Scanner sc = new Scanner(System.in);
        System.out.println("String 1: ");
        S1 = sc.nextLine();
        System.out.println("String 2: ");
        S2 = sc.nextLine();

        Bai1 B1 = new Bai1();
        B1.input(S1, S2);
        B1.process();
    }

    public void input(String S1, String S2) {
        String[] myS1 = S1.split(" ");
        String[] myS2 = S2.split(" ");

        for (String x : myS1) {
            list1.add(Integer.parseInt(x));
        }
        for (String x : myS2) {
            list2.add(Integer.parseInt(x));
        }

    }

    public void process() {
        int sizeL1 = list1.size();
        int sizeL2 = list2.size();
        int size = sizeL1 < sizeL2 ? sizeL1 : sizeL2;

        int pos = -1;

        for (int i = 0; i < size; i++) {
            int L1 = list1.get(i);
            int L2 = list2.get(i);
            if (L1 != L2) {
                pos = i;
                break;
            }
        }

        System.out.println("");
        System.out.print("Output: ");
        if (pos > -1) {
            if (sizeL1 > sizeL2) {
                System.out.println(list1.get(pos));
            }
            if (sizeL1 < sizeL2) {
                System.out.println(list2.get(pos));
            }
        } else {
            if (sizeL1 > sizeL2) {
                System.out.println(list1.get(list1.size() - 1));
            }
            if (sizeL1 < sizeL2) {
                System.out.println(list2.get(list2.size() - 1));
            }
        }

    }
}
