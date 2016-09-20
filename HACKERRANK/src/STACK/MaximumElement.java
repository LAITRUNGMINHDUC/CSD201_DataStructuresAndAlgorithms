/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STACK;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author duclt
 */
public class MaximumElement {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int max = Integer.MIN_VALUE;
            Stack<StackNode> stack = new Stack<>();
            
            for (int i = 0; i < n; i++) {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        int value = sc.nextInt();
                        max = Math.max(value, max);
                        stack.add(new StackNode(value, max));
                    case 2:
                        if (!stack.isEmpty()) {
                            stack.pop();
                        }
                        if (stack.isEmpty()) {
                            max = Integer.MIN_VALUE;
                        } else {
                            max = stack.peek().currentMax;
                        }
                    case 3:
                        if (!stack.isEmpty()) {
                            System.out.println(stack.peek().currentMax);
                        }
                }
            }
        }
    }
}

class StackNode {

    int value;
    int currentMax;

    public StackNode(int value, int currentMax) {
        this.value = value;
        this.currentMax = currentMax;
    }
}
