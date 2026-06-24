package StackQueue;

import java.util.Arrays;

public class StockSpanProblemBruteForce {
    private static int[] calculateSpan(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i; j >= 0; j--) {
                if (arr[j] <= arr[i]) count++;
                else {
                    break;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {100, 60, 100, 80, 120};
        System.out.println(Arrays.toString(calculateSpan(arr)));
    }
}
