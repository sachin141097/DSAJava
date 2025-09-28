package com.leetcode.solutions.csesIntroductory;

import java.util.Scanner;

/*
Brute Force:
1. First calculate factorial of N then count trailing zeros in the result
2. We can find the trailing zeros by repetedely dividing the factorial by 10 till the remainder is zero

Optimised
 PROBLEM: Trailing Zeros in Factorial
 *
 * Given an integer n, return the number of trailing zeros in n! (n factorial).
 *
 * EXAMPLES:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zeros.
 *
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 *
 * Input: n = 10
 * Output: 2
 * Explanation: 10! = 3628800, two trailing zeros.
 *
 * KEY INSIGHT:
 * Trailing zeros are produced by factors of 10, and 10 = 2 × 5.
 * In any factorial, there are always more factors of 2 than factors of 5.
 * Therefore, the number of trailing zeros = number of times 5 divides n!
 *
 * We need to count:
 * - Numbers divisible by 5: n/5
 * - Numbers divisible by 25 (5²): n/25 (these contribute an extra 5)
 * - Numbers divisible by 125 (5³): n/125 (these contribute another extra 5)
 * - And so on...
 *
 * ALGORITHM:
 * Count = n/5 + n/25 + n/125 + n/625 + ...
 * This continues until 5^k > n
 */
public class TrailingZeros {
    public static int countTrailingZeros(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countTrailingZeros(n));

    }
}
