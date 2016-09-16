/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex05_p212;

/**
 *
 * @author duclt
 */
public class MazeCell {

    public int x, y;

    public MazeCell() {
    }

    public MazeCell(int i, int j) {
        x = i;
        y = j;
    }

    public boolean equals(MazeCell cell) {
        return x == cell.x && y == cell.y;
    }
}
