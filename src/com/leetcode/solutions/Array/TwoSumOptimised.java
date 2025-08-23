package com.leetcode.solutions.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

//Time Complexity: O(N)
public class TwoSumOptimised {
    private static int[] getTwoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (mp.containsKey(delta)) {
                return new int[]{mp.get(delta), i};
            }
            mp.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 4, 8};
        int target = 10;
        System.out.println(Arrays.toString(getTwoSum(nums, target)));
    }
}
