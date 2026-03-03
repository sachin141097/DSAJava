package Recursion;

/*
                                   []
                         / include 1        \ exclude 1
                       [1]                   []
                 / include 2   \ exclude 2   / include 2   \ exclude 2
             [1,2]              [1]        [2]              []
          / inc3  \ exc3     / inc3 \ exc3 / inc3 \ exc3   / inc3 \ exc3
      [1,2,3]      [1,2]     [1,3]   [1]   [2,3]  [2]     [3]    []
 */

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    private static void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        //base case
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        //choice 1 : choose current element
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);
        //backtrack: un-choose
        current.remove(current.size() - 1);
        //choice 2: exclude current element
        backtrack(nums, index + 1, current, result);


    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));

    }
}
