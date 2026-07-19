package StackQueue;

import java.util.Stack;

public class SumOfSubArrayMinimums {
    private static long findSum(int[] arr) {
        final long MOD = 1_000_000_007L;
        int n = arr.length;
        int[] left = findNextSmallestFromLeft(arr);
        int[] right = findNextSmallestFromRight(arr);
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int startingPoint = i - left[i];
            int endingPoint = right[i] - i;
            sum += (arr[i] * startingPoint * endingPoint) % MOD;
        }

        return sum;
    }

    private static int[] findNextSmallestFromLeft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
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

    private static int[] findNextSmallestFromRight(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5};
        System.out.println(findSum(arr));
    }
}
