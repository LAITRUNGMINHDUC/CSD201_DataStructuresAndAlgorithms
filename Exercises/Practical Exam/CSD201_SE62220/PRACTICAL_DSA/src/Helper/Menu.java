/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.ArrayList;

/**
 *
 * @author duclt
 */
public class Menu extends ArrayList {

    @Override
    public String toString() {
        String S = "";
        for (int i = 0; i < this.size(); i++) {
            S = S + (i + 1) + "." + this.get(i) + "\n";
        }
        return S;
    }
}
