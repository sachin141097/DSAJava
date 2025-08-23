package com.leetcode.solutions.Array;

import java.util.Scanner;

public class ValidAnagram {
    private static boolean checkAnagram(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] charFreq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charFreq[s1.charAt(i) - 'a']++;
            charFreq[s2.charAt(i) - 'a']--;
        }
        for (int freq : charFreq) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String string1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String string2 = sc.nextLine();
        boolean result = checkAnagram(string1, string2);
        if (result) {
            System.out.println("Two strings are anagram of each other");
        } else {
            System.out.println("Two strings are not anagram of each other");
        }

    }
}
