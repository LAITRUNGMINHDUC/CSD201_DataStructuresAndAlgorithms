/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloydTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author duclt
 */
public class Test {

    int Graph[][], Trace[][];
    int n;

    public void inputGraph(String fileName) {
        try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)) {

            String[] firstLine = br.readLine().split(" ");
            n = Integer.parseInt(firstLine[0]);

            Graph = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        Graph[i][j] = -1000;
                    } else {
                        Graph[i][j] = 1000;
                    }
                }
            }

            int a, b, c;
            for (int i = 0; i < n; i++) {
                String[] line = br.readLine().split(" ");
                a = Integer.parseInt(line[0]);
                b = Integer.parseInt(line[1]);
                c = Integer.parseInt(line[2]);
                Graph[a][b] = c;
                Graph[b][a] = c;
            }

        } catch (IOException | NumberFormatException e) {
        }
    }

    public void Floyd() {
        Trace = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Trace[i][j] = j;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (Graph[u][v] > Graph[u][k] + Graph[k][v]) {
                        Graph[u][v] = Graph[u][k] + Graph[k][v];
                        Trace[u][v] = Trace[u][k];
                    }
                }
            }
        }
    }

    public void export() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Trace[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public void findWay(int S, int F) {
        do {
            System.out.println(S);
            S = Trace[S][F];
        } while (S != F);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.inputGraph("TinyMap.txt");
        test.Floyd();
        test.export();
        //test.findWay(0, 3);
    }
}
