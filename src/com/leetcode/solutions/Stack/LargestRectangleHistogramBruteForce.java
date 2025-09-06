package com.leetcode.solutions.Stack;

/*
Time Complexity: O(N^2)
 */
public class LargestRectangleHistogramBruteForce {
    private static int findLargestArea(int[] arr) {
        int n = arr.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            //Find Left boundary(first bar smaller than current)
            int left = i;
            //from i to 0
            while (left > 0 && arr[left - 1] >= height) {
                left--;
            }
            int right = i;

            //from i to n-1
            while (right < n - 1 && arr[right + 1] >= height) {
                right++;
            }
            int width = right - left + 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4};
        System.out.println(findLargestArea(arr));
    }
}
