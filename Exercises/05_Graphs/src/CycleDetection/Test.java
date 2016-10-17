/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CycleDetection;

/**
 *
 * @author duclt
 */
public class Test {

    public static void main(String[] args) {
        Graph myGraph = new Graph("TinyMap.txt");

        CycleDetection Detect = new CycleDetection(myGraph);        
        System.out.println(Detect.FloydDetection());        
        
        myGraph.exportMap();
        myGraph.exportTrace();
        myGraph.findWay();
    }
}
