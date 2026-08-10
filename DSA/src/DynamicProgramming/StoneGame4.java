package DynamicProgramming;

import java.util.Arrays;

/*
Time Complexity: O(n*(n^(1/2))
 */
public class StoneGame4 {

    private static boolean solve(int n, int[] dp) {

        // No stones -> current player loses
        if (n == 0) {
            return false;
        }

        if (dp[n] != -1) {
            return dp[n] == 1;
        }

        // Try every possible square number
        for (int k = 1; k * k <= n; k++) {

            int remaining = n - (k * k);

            // If opponent loses, current player wins
            if (!solve(remaining, dp)) {
                dp[n] = 1;
                return true;
            }
        }

        // Every possible move makes opponent win
        dp[n] = 0;
        return false;
    }

    private static boolean winnerSquaregame(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(winnerSquaregame(n));
    }
}
