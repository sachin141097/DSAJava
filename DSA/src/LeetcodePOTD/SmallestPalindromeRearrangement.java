package LeetcodePOTD;

import java.math.BigInteger;
import java.util.HashMap;

/*
You are given a palindromic string s and an integer k.

Return the k-th lexicographically smallest palindromic permutation of s. If there are fewer than k distinct palindromic permutations, return an empty string.

Note: Different rearrangements that yield the same palindromic string are considered identical and are counted once.



Example 1:

Input: s = "abba", k = 2

Output: "baab"

Explanation:

The two distinct palindromic rearrangements of "abba" are "abba" and "baab".
Lexicographically, "abba" comes before "baab". Since k = 2, the output is "baab".
Example 2:

Input: s = "aa", k = 2

Output: ""

Explanation:

There is only one palindromic rearrangement: "aa".
The output is an empty string since k = 2 exceeds the number of possible rearrangements.
 */
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class SmallestPalindromeRearrangement {
    private static String kthPalindrome(String s, int k) {
        //----------------------------------------------------
        // Step 1 : Count frequency of every character.
        //----------------------------------------------------
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        //----------------------------------------------------
        // Step 2 : Build left-half frequency map.
        //----------------------------------------------------
        HashMap<Character, Integer> leftMap = new HashMap<>();
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        Collections.sort(chars);
        char middle = '$';
        boolean hasMiddle = false;
        int leftLength = 0;
        for (char c : chars) {
            int count = freqMap.get(c);
            leftMap.put(c, count / 2);
            leftLength += count / 2;
            if (count % 2 == 1) {
                middle = c;
                hasMiddle = true;
            }
        }

        //Step 3: Check whether kth palindrome exists
        BigInteger total = countWays(leftMap, leftLength);
        if (total.compareTo(BigInteger.valueOf(k)) < 0) {
            return "";
        }

        //----------------------------------------------------
        // Step 4 : Build left half greedily.
        //----------------------------------------------------
        StringBuilder left = new StringBuilder();
        while (left.length() < leftLength) {
            //------------------------------------------------
            // Try every character from smallest to largest.
            //------------------------------------------------
            for (char c : chars) {
                if (leftMap.get(c) == 0) {
                    continue;
                }
                //------------------------------------------------
                // Temporarily use one occurrence.
                //------------------------------------------------

                leftMap.put(c, leftMap.get(c) - 1);

                //------------------------------------------------
                // Count how many palindromes are possible
                // after fixing this character.
                //------------------------------------------------

                BigInteger ways = countWays(leftMap, leftLength);

                //------------------------------------------------
                // If enough palindromes exist,
                // this character belongs here.
                //------------------------------------------------
                if (ways.compareTo(BigInteger.valueOf(k)) >= 0) {
                    left.append(c);
                    break;
                }

                //------------------------------------------------
                // Otherwise skip all those palindromes.
                //------------------------------------------------
                k -= ways.longValue();
                //------------------------------------------------
                // Restore because we are trying next character.
                //------------------------------------------------

                leftMap.put(c, leftMap.get(c) + 1);
            }
        }
        //----------------------------------------------------
        // Step 5 : Build final palindrome.
        //----------------------------------------------------

        StringBuilder result = new StringBuilder(left);

        if (hasMiddle) {
            result.append(middle);
        }

        result.append(new StringBuilder(left).reverse());

        return result.toString();
    }

    private static BigInteger countWays(HashMap<Character, Integer> leftMap, int leftLength) {
        List<BigInteger> factorial = new ArrayList<>();
        // Counts distinct permutations using
        // n! / (a! * b! * c! ...)
        int length = 0;
        for (int count : leftMap.values()) {
            length += count;
        }
        factorial.add(BigInteger.ONE);
        for (int i = 1; i <= leftLength; i++) {
            factorial.add(factorial.get(i - 1).multiply(BigInteger.valueOf(i)));
        }
        BigInteger ans = factorial.get(length);
        for (int count : leftMap.values()) {
            ans = ans.divide(factorial.get(count));
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "aabbcc";
        System.out.println(kthPalindrome(s, 1));
        System.out.println(kthPalindrome(s, 2));
        System.out.println(kthPalindrome(s, 3));

    }
}
