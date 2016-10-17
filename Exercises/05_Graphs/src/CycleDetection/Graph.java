package CycleDetection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author duclt
 */
public class Graph {

    int numVertices, numEdges;
    String fileName;
    int Graph[][];
    int Trace[][];

    public Graph(String fileName) {
        this.fileName = fileName;
        inputGraph();
    }

    public void initGraph() {
        this.Graph = new int[numVertices][numVertices];
        this.Trace = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    Graph[i][j] = 0;
                } else {
                    Graph[i][j] = 100;
                }
            }
        }
    }

    public void inputGraph() {
        try (FileReader fr = new FileReader(fileName); BufferedReader br = new BufferedReader(fr)) {

            String[] firstLine = br.readLine().split(" ");
            numVertices = Integer.parseInt(firstLine[0]);
            numEdges = Integer.parseInt(firstLine[1]);

            int a, b, c;
            initGraph();
            for (int i = 0; i < numEdges; i++) {
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

    public void exportMap() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void exportTrace() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(Trace[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void findWay() {
        int S = 0;
        int F = 3;
        do {
            System.out.println(S);
            S = Trace[S][F];
        } while (S == F);

    }

}
