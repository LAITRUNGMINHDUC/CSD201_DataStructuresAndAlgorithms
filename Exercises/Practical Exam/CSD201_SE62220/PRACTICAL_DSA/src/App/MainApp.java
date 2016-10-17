/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Helper.Menu;
import java.util.Scanner;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String[] args) {
        Helper.Menu menu = new Menu();
        menu.add("Bai 1");
        menu.add("Bai 2");
        menu.add("Bai 3");

        while (true) {
            System.out.println("");
            System.out.println(menu);
            System.out.println("Your choice: ");
            Scanner sc = new Scanner(System.in);
            int k = sc.nextInt();

            switch (k) {
                case 1:
                    App.Bai1.main(args);
                    break;
                case 2:
                    App.Bai2.main(args);
                    break;
                case 3:
                    App.Bai3.main(args);
                    break;
            }
        }
    }
}
