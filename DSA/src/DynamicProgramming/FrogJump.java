package DynamicProgramming;

/*
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.

To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from any step either one or two steps, provided it exists.

Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
Example 1
Input: heights = [2, 1, 3, 5, 4]
Output: 2
Explanation:
One possible route can be,
0th step -> 2nd Step = abs(2 - 3) = 1
2nd step -> 4th step = abs(3 - 4) = 1
Total = 1 + 1 = 2.
Example 2
Input: heights = [7, 5, 1, 2, 6]
Output: 9
Explanation:
One possible route can be,
0th step -> 1st Step = abs(7 - 5) = 2
1st step -> 3rd step = abs(5 - 2) = 3
3rd step -> 4th step = abs(2 - 6) = 4
Total = 2 + 3 + 4 = 9.
 */

import java.util.Arrays;

public class FrogJump {
    private static int frogJump(int[] heights) {
        int[] dp = new int[10001];
        Arrays.fill(dp, -1);
        return solve(heights.length - 1, heights, dp);
    }

    private static int solve(int step, int[] heights, int[] dp) {
        if (step == 0) {
            return 0;
        }
        if (dp[step] != -1) {
            return dp[step];
        }
        int oneStepWays = Integer.MAX_VALUE;
        int twoStepWays = Integer.MAX_VALUE;
        if (step >= 1) {
            oneStepWays = Math.abs(heights[step] - heights[step - 1]) + solve(step - 1, heights, dp);
        }
        if (step >= 2) {
            twoStepWays = Math.abs(heights[step] - heights[step - 2]) + solve(step - 2, heights, dp);
        }
        dp[step] = Math.min(oneStepWays, twoStepWays);
        return dp[step];
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 3, 5, 4};
        System.out.println(frogJump(heights));

    }
}
