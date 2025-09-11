package com.leetcode.solutions.csesIntroductory;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n - 1];
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        long totalSum = ((long) n * ((long) n + 1)) / 2;
        System.out.println(totalSum - sum);


    }
}
