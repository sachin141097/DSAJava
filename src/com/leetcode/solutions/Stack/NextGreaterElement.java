package com.leetcode.solutions.Stack;
/*
Given an array arr of size n containing elements, find the next greater element for each element in the array in the order of their appearance.



The next greater element of an element in the array is the nearest element on the right that is greater than the current element.



If there does not exist a next greater element for the current element, then the next greater element for that element is -1.


Examples:
Input: arr = [1, 3, 2, 4]

Output: [3, 4, 4, -1]

Explanation: In the array, the next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4 is -1, since it does not exist.

Input: arr = [6, 8, 0, 1, 3]

Output: [8, -1, 1, 3, -1]

Explanation: In the array, the next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1 , for 1 it is 3 and then for 3 there is no larger element on the right and hence -1.
 */

import java.util.Arrays;

public class NextGreaterElement {
    private static int[] NextGreaterElementBruteForce(int[] arr) {
        /*
        Time Complexity: O(N^2)
         */
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        int[] result = NextGreaterElementBruteForce(arr);
        System.out.println(Arrays.toString(result));

    }
}
