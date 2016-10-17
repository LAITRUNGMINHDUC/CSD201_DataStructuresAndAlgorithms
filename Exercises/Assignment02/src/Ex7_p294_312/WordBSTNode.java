/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7_p294_312;

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
    LinkedList<String> latinList = new LinkedList<>();

    public WordBSTNode(String data, WordBSTNode left, WordBSTNode right, String latin) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.latinList.add(latin);
    }

    @Override
    public String toString() {
        return this.data + " : " + Arrays.toString(latinList.toArray());
    }
}
