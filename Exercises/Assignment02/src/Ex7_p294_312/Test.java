/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7_p294_312;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author duclt
 */
public class Test {

    WordBST tree = new WordBST();

    public void constructTreeAndPrintResult() {
        String fileName = "LatinEnglish.txt";

        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String S;

            while ((S = br.readLine()) != null) {
                if (S.charAt(0) == '%') {
                    tree.traversalTree(tree.root);                    
                    System.out.println("\n" + S);
                } else {
                    String[] arrLatinEng = S.split(":");
                    String[] arrEng = arrLatinEng[1].split(",");

                    for (String Eng : arrEng) {
                        WordBSTNode node = tree.findWordPos(tree.root, Eng);
                        if (node == null) {
                            tree.insertWordNode(Eng, arrLatinEng[0]);
                        } else {
                            node.latinList.add(arrLatinEng[0]);
                        }
                    }
                }
            }
            tree.traversalTree(tree.root);
            tree.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.constructTreeAndPrintResult();
    }
}
