package StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToRight {
    private static int[] findNextGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
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
        System.out.println(Arrays.toString(findNextGreater(arr)));
    }
}
