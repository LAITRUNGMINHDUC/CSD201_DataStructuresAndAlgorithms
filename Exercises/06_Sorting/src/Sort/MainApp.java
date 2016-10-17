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
public class MainApp {

    public static void main(String[] args) {
        int[] data = {5, 4, 6};
        SortAlgorithm Sort = new SortAlgorithm();
        Sort.insertionSort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
            System.out.println(i);
        }
    }

}
