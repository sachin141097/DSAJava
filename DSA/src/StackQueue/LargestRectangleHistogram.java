package StackQueue;

import java.util.Stack;

public class LargestRectangleHistogram {
    private static int[] findNextSmallerFromRight(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = arr.length;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private static int[] findNextSmallerFromLeft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 7, 5, 9};
        int[] right = findNextSmallerFromRight(arr);
        int[] left = findNextSmallerFromLeft(arr);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxArea = Math.max(maxArea, arr[i] * (right[i] - left[i] - 1));
        }
        System.out.println(maxArea);

    }
}