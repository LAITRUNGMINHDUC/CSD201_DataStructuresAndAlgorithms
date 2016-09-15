/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex10;

/**
 *
 * @author duclt
 */
public class MainApp {
    
    static IntSLLNodeList L = new IntSLLNodeList();
    
    public static void main(String args[]) {
        for (int i = 0; i < 9; i++) {
            L.addToHead(i);
        }        
        int pos = 5;
        L.removeFromPos(pos);
        L.printAll();
    }
}
