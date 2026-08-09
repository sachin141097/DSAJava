package DynamicProgramming;

import java.util.Arrays;

public class MaximumSumOfNonAdjacent {
    private static int maximumNonAdjacentSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp, n);
    }

    private static int solve(int startIndex, int[] nums, int[] dp, int n) {
        if (startIndex >= n) {
            return 0;
        }
        if (dp[startIndex] != -1) {
            return dp[startIndex];
        }
        int takeElement = nums[startIndex] + solve(startIndex + 2, nums, dp, n);
        int dropElement = solve(startIndex + 1, nums, dp, n);
        dp[startIndex] = Math.max(takeElement, dropElement);
        return dp[startIndex];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 4, 9};
        System.out.println(maximumNonAdjacentSum(nums));
    }
}
