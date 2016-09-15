package CourseBook_IntSLLNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duclt
 */
public class IntSLL {

    public static void main(String args[]) throws Exception {
        IntSLLNodeList l = new IntSLLNodeList();
        for (int i = 0; i < 10; i++) {
            l.addToHead(i);
        }
        System.out.println(l.get(100));
    }
}
