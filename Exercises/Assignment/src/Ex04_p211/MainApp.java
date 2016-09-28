/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex04_p211;

import java.io.*;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String[] args) {
        String bigText;
        System.out.println("Demo 01: ");
        bigText = loadData("src/Ex04_p211/Demo01.txt");
        System.out.println(NewFormat.Pretty(bigText, 1));

        System.out.println("Demo 02: ");
        bigText = loadData("src/Ex04_p211/Demo03.txt");
        System.out.println(NewFormat.Pretty(bigText, 1));

    }

    static String loadData(String fileName) {
        File f = new File(fileName);
        String Tmp = "";
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String S = "";
            while ((S = br.readLine()) != null) {
                Tmp = Tmp + S.trim();
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Tmp + "\n");
        return Tmp.trim();
    }
}
