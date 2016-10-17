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
public class CycleDetection {

    Graph myGraph;

    public CycleDetection(Graph myGraph) {
        this.myGraph = myGraph;
    }

    boolean DFSDetection(int u) {

    }

    int FloydDetection() {
        int n = myGraph.numVertices;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                myGraph.Trace[i][j] = j;
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (myGraph.Graph[u][v] > myGraph.Graph[u][k] + myGraph.Graph[k][v]) {
                        myGraph.Graph[u][v] = myGraph.Graph[u][k] + myGraph.Graph[k][v];
                        myGraph.Trace[u][v] = myGraph.Trace[u][k];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (myGraph.Graph[i][i] != -1000) {
                return i;
            }
        }
        return -1;
    }
}
