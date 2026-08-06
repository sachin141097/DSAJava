package DynamicProgramming;

import java.util.Arrays;

/*
Time complexity: O(N)
Space Complexity: O(N)
 */
public class ClimbingStairs {
    private static int findTotalWays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    private static int solve(int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int oneStepWays = solve(n - 1, dp);
        int twoStepWays = solve(n - 2, dp);
        dp[n] = oneStepWays + twoStepWays;
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 45;
        System.out.println(findTotalWays(n));
    }
}
