/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author duclt
 */
public class Bai3 {

    LinkedList<Integer> list = new LinkedList<>();
    ArrayList<Integer> tmp = new ArrayList<>();

    public static void main(String[] args) {
        String S = "11 7 4 2 1 6";

//        Scanner sc = new Scanner(System.in);
//        System.out.println("String: ");
//        S = sc.nextLine();
        Bai3 B3 = new Bai3();
        B3.input(S);

        System.out.println("");
        System.out.println("Output: ");

        System.out.println(B3.process());

    }

    public void input(String S) {
        String[] myS = S.split(" ");
        for (String x : myS) {
            list.add(Integer.parseInt(x));
        }
    }

    public boolean process() {
        for (int i = 0; i < list.size() - 1; i++) {
            int differ = Math.abs(list.get(i) - list.get(i + 1));
            if (!inJolly(differ)) {
                return false;
            }
        }

        boolean[] flag = new boolean[list.size()];
        for (int i = 1; i < list.size(); i++) {
            flag[i] = false;
        }
        for (int i = 0; i < tmp.size(); i++) {
            flag[tmp.get(i)] = true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (flag[i] == false) {
                return false;
            }
        }
        return true;
    }

    public boolean inJolly(int i) {
        if (i >= list.size() || i < 1) {
            return false;
        }
        tmp.add(i);
        return true;
    }
}
