/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex5_p294_312;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author duclt
 */
public class Test {

    WordBST tree = new WordBST();

    public void constructTree() {
        String fileName = "CrossReference.txt";

        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String S;
            int lineNo = 0;

            while ((S = br.readLine()) != null) {
                S = S.trim().toLowerCase();
                String[] arr = S.split(" ");
                lineNo++;

                for (int i = 0; i < arr.length; i++) {
                    WordBSTNode node = tree.findWordPos(tree.root, arr[i]);
                    if (node == null) {
                        tree.insertWordNode(arr[i], lineNo);
                    } else {
                        node.lineNo.add(lineNo);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTreeAlphabetical() {
        tree.traversalTree(tree.root);
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.constructTree();
        t.printTreeAlphabetical();
    }
}
