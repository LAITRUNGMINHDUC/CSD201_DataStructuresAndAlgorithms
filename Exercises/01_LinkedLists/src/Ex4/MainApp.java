/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

/**
 *
 * @author duclt
 */
public class MainApp {
    
    public static void main(String args[]) {
        IntSLLNodeList L1 = new IntSLLNodeList();
        IntSLLNodeList L2 = new IntSLLNodeList();
        
        for (int i = 0; i < 10; i++) {
            L1.addToHead(i);
            L2.addToHead(i-1);
            //L2.addToHead(i);
        }
        
        if ((L1.count == L2.count) && (!L1.isEmpty())) {
            for (int i = 0; i < L1.count; i++) {
                if (L1.get(i) != L2.get(i)) {
                    System.out.println("2 lists are not equal.");
                    return;
                }
            }
            System.out.println("2 lists are equal.");
        }
        
    }
}
