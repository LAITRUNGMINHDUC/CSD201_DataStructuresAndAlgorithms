/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex5_p294_312;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author duclt
 */
public class WordBSTNode {

    String data;
    WordBSTNode left;
    WordBSTNode right;
    LinkedList<Integer> lineNo = new LinkedList<>();

    public WordBSTNode(String data, WordBSTNode left, WordBSTNode right, int lineNo) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.lineNo.add(lineNo);
    }

    @Override
    public String toString() {
        return this.data + " : " + Arrays.toString(lineNo.toArray());
    }

    public String manualToString() {
        String S = this.data + " : ";
        do {
            S = S + " " + lineNo.remove();
        } while (!lineNo.isEmpty());
        return S;
    }
}
