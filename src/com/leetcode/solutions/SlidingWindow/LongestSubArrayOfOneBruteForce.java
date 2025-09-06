package com.leetcode.solutions.SlidingWindow;

/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

Example 1:

Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:

Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:

Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.

Constraints:

    1 <= nums.length <= 105
    nums[i] is either 0 or 1.

 */
public class LongestSubArrayOfOneBruteForce {
    private static int findMax(int[] arr, int index) {
        int currentLength = 0;
        int maxLength = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i == index) {
                continue;
            }
            if (arr[i] == 1) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1};
        int n = arr.length;
        int result = 0;
        int countZero = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZero++;
                result = Math.max(result, findMax(arr, i));
            }
        }
        if (countZero == 0) {
            System.out.println(n - 1);
        } else {
            System.out.println(result);
        }

    }
}
