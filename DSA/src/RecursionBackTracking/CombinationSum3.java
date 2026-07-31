package RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    private static void findTargetSum(int[] candidates, int startIndex, int target, List<List<Integer>> ans, List<Integer> result, int k) {
        if (target == 0 && result.size() == k) {
            ans.add(new ArrayList<>(result));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            result.add(candidates[i]);//pick the element
            findTargetSum(candidates, i + 1, target - candidates[i], ans, result, k);
            result.remove(result.size() - 1);//unpick the element
        }

    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        findTargetSum(candidates, 0, target, ans, result, k);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 7;
        int k = 3;
        List<List<Integer>> ans = combinationSum(candidates, target, k);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }

    }
}
