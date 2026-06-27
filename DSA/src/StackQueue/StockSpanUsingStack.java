package StackQueue;

import java.util.Stack;
import java.util.Arrays;

public class StockSpanUsingStack {
    private static int[] findPreviousGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private static int[] findStockSpan(int[] arr) {
        int[] previousGreater;
        previousGreater = findPreviousGreater(arr);
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            if (previousGreater[i] == -1) {
                ans[i] = 1;
            } else {
                ans[i] = i - previousGreater[i];
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {120, 100, 60, 80, 90, 110, 115};
        System.out.println(Arrays.toString(findStockSpan(arr)));
    }
}
