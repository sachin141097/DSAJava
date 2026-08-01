package RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSum2 {
    private static void findTargetSum(int[] candidates, int startIndex, int target, List<List<Integer>> ans, List<Integer> result) {
        if (target == 0) {
            ans.add(new ArrayList<>(result));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1])
                continue; //this prevents starting same branches from the same recursion level
            result.add(candidates[i]);//pick the element
            findTargetSum(candidates, i + 1, target - candidates[i], ans, result);
            result.remove(result.size() - 1);//unpick the element
        }

    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        findTargetSum(candidates, 0, target, ans, result);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        Arrays.sort(candidates);
        int target = 8;
        List<List<Integer>> ans = combinationSum(candidates, target);
        for (List<Integer> result : ans) {
            System.out.println(result);
        }

    }
}
