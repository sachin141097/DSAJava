package com.leetcode.solutions.Stack;

import java.util.Arrays;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {3, 8, 5, 2, 25};
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
