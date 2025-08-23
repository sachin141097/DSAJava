package StriverA2ZandNeetCode250.Array;

import java.util.Arrays;

//Time Complexity: O(N^2)
public class TwoSum {
    private static int[] findTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 26;
        int[] ans = findTwoSum(nums, target);
        System.out.println(Arrays.toString(ans));

    }
}
