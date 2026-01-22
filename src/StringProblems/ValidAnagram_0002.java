package StringProblems;
/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.



An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


Example 1

Input : s = "anagram" , t = "nagaram"

Output : true

Explanation :

We can rearrange the characters of string s to get string t as frequency of all characters from both strings is same.

Example 2

Input : s = "dog" , t = "cat"

Output : false

Explanation :

We cannot rearrange the characters of string s to get string t as frequency of all characters from both strings is not same.
 */

import java.util.Arrays;
import java.util.Scanner;

public class ValidAnagram_0002 {
    private static boolean isAnagram(String s, String t) {
        String s1 = s.toLowerCase();
        String s2 = t.toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two strings");
        String s = sc.next();
        String t = sc.next();
        boolean ans = isAnagram(s, t);
        if (ans) {
            System.out.println("Both strings are anagrams of each other");
        } else {
            System.out.println("Both strings are not anagram of each other");
        }
    }
}
