package com.leetcode.solutions.Stack;

import java.util.Stack;
import java.util.Arrays;

public class NextSmallerElementUsingStack {
    public static void main(String[] args) {
        int[] arr = {3, 8, 5, 2, 25};
        int[] res = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = s.peek();
            }
            s.push(arr[i]);
        }
        System.out.println(Arrays.toString(res));
    }
}
