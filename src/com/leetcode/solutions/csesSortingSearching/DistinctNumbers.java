package com.leetcode.solutions.csesSortingSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Set<Integer> s = new HashSet<>();
        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(numbers[i]);
            s.add(num);
        }
        System.out.println(s.size());
    }

}
