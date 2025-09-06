package com.leetcode.solutions.Stack;

import java.util.Arrays;
import java.util.Stack;

/*
Time Complexity: O(N)
 */
public class NextGreaterElementUsingStack {
    private static int[] findNextGreaterElement(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = s.peek();
            }
            s.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int[] result = findNextGreaterElement(arr);
        System.out.println(Arrays.toString(result));
    }
}
