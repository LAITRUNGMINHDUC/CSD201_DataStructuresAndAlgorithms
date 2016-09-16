/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex05_p212;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author duclt
 */
public class Maze {

    private int rows = 0, cols = 0;
    private MazeCell exitCell = new MazeCell(),
            entryCell = new MazeCell();

    private final char exitMarker = 'e',
            entryMarker = 'm',
            visited = '.';
    private final char passage = '0', wall = '1';

    private String filename;

    private char[][] myMaze;

    public Maze(String filename) {
        this.filename = filename;
        if (readFile()) {
            if (!exitMaze(entryCell)) {
                System.out.println("No way out");
            } else {
                displayMaze();
            }
        } else {
            System.out.println("Error input.");
        }

    }

    private boolean readFile() {
        try {
            File f = new File(filename);
            if (!f.exists()) {
                return false;
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String[] Temp = br.readLine().split(" ");
            rows = Integer.parseInt(Temp[0]);
            cols = Integer.parseInt(Temp[1]);
            myMaze = new char[rows][cols];

            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);
                    myMaze[count][i] = ch;
                    if (ch == exitMarker) {
                        exitCell.x = count;
                        exitCell.y = i;
                    } else if (ch == entryMarker) {
                        entryCell.x = count;
                        entryCell.y = i;
                    }
                }
                count++;
            }
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    private boolean exitMaze(MazeCell currentCell) {
        int x = currentCell.x;
        int y = currentCell.y;

        if (currentCell.equals(exitCell)) {
            return true;
        }

        if (validCell(currentCell)) {
            myMaze[x][y] = visited;

            if (exitMaze(new MazeCell(x + 1, y))) {
                return true;
            }
            if (exitMaze(new MazeCell(x - 1, y))) {
                return true;
            }
            if (exitMaze(new MazeCell(x, y - 1))) {
                return true;
            }
            if (exitMaze(new MazeCell(x, y + 1))) {
                return true;
            }

            myMaze[x][y] = passage;
            return false;
        }
        return false;
    }

    private void displayMaze() {
        myMaze[entryCell.x][entryCell.y] = entryMarker;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(myMaze[i][j]);
            }
            System.out.println();
        }
    }

    private boolean validCell(MazeCell cell) {
        int x = cell.x;
        int y = cell.y;
        return (x >= 0 && x < rows) && (y >= 0 && y < cols)
                && (myMaze[x][y] != wall) && (myMaze[x][y] != visited);
    }
}
