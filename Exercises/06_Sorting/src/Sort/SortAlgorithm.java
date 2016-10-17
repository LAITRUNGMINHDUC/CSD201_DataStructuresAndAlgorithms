/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sort;

/**
 *
 * @author duclt
 */
public class SortAlgorithm {

    void Swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    void insertionSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int tmp = data[i];
            int j = i - 1;
            while (j >= 0) {
                if (data[j] >= tmp) {
                    data[j + 1] = data[j];
                } else {
                    break;
                }
                j--;
            }
            data[j + 1] = tmp;
        }
    }
}
