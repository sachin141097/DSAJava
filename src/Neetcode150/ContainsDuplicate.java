package Neetcode150;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    private static boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) {
            if (s.contains(num)) {
                return true;
            }
            s.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(hasDuplicate(nums));
    }
}
