package com.leetcode.solutions.SlidingWindow;

/*
Time complexity: O(N)
Space Complexity: O(1)
 */
public class MaximumSumSubArraySizeK {
    public static int maxSubArraySumK(int[] arr, int k) {
        int n = arr.length;
        if (n < k || k <= 0) {
            throw new IllegalArgumentException("K must be positive and <= array length");
        }
        int i = 0;//start of window
        int j = 0;//end of window
        int sum = 0;//current window sum
        int maxSum = Integer.MIN_VALUE;//answer variable

        while (j < n) {
            sum += arr[j];
            if (j - i + 1 < k) {
                j++;//expand the window
            } else if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                //slide the window: remove the element going out
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;

    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSubArraySumK(arr, k);
        System.out.println(result);
    }
}
