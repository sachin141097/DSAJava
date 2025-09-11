package com.leetcode.solutions.csesIntroductory;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.length() <= 1) {
            System.out.println(s.length());
            return;
        }
        int maxLength = 0;
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                maxLength = Math.max(count, maxLength);
                count = 1;
            }
        }
        maxLength = Math.max(count, maxLength);
        System.out.println(maxLength);
    }
}
