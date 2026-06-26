package StackQueue;

import java.util.Stack;
import java.util.Arrays;

public class NearestGreaterToLeft {
    private static int[] findNearestGreaterToLeft(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        System.out.println(Arrays.toString(findNearestGreaterToLeft(arr)));
    }
}
