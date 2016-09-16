/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex03_p166;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String[] args) {
        String filename = "src/Ex03_p166/";
        filename = filename + "TestCase.txt";
        
        System.out.println("Delimiter match: " + DelimiterMatching.Matching(filename));
    }
}
