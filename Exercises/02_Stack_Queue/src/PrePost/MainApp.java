/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrePost;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duclt
 */
public class MainApp {

    public static void main(String[] args) throws Exception {
        Prefix prefix = new Prefix();
        Postfix postfix = new Postfix();

        Thread t1 = new Thread(prefix);
        t1.start();
        t1.join();
        Thread t2 = new Thread(postfix);
        t2.start();
    }
}

class Prefix extends Thread {

    public Prefix() {
        super();
    }

    public void run() {
        String prefix = "+ 10 3";
        try {
            Prefix(prefix);
        } catch (Exception ex) {
            Logger.getLogger(Prefix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void Prefix(String S) throws Exception {
        System.out.println("Prefix String: " + S);
        System.out.println("Result: " + Calculator.preCalculate(S));
        System.out.println("Prefix to Postfix: " + Converter.preToPost(S));
        System.out.println("");
    }

}

class Postfix extends Thread {

    public Postfix() {
        super();
    }

    public void run() {
        String postfix = "10 3 +";
        try {
            Postfix(postfix);
        } catch (Exception ex) {
            Logger.getLogger(Postfix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void Postfix(String S) throws Exception {
        System.out.println("Postfix String: " + S);
        System.out.println("Result: " + Calculator.postCalculate(S));
        System.out.println("Postfix to Prefix: " + Converter.postToPre(S));
        System.out.println("");
    }

}
