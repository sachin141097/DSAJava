package DynamicProgramming;

import java.util.Arrays;

/*
Time Complexity: O(N)
Space Complexity: O(N)
 */
public class HouseRobber {
    private static int findMaxProfit(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }

    private static int solve(int house, int[] nums, int[] dp) {
        if (house >= nums.length) {
            return 0;
        }
        if (dp[house] != -1) {
            return dp[house];
        }
        int robHouse = nums[house] + solve(house + 2, nums, dp);
        int skipHouse = solve(house + 1, nums, dp);
        dp[house] = Math.max(robHouse, skipHouse);
        return dp[house];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(findMaxProfit(nums));
    }
}
