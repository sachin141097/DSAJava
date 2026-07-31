package RecursionBackTracking;

/*
Provided with a goal integer target and an array of unique integer candidates, provide a list of all possible combinations of candidates in which the selected numbers add up to the target. The combinations can be returned in any order.

A candidate may be selected from the pool an infinite number of times. There are two distinct combinations if the frequency of at least one of the selected figures differs.

The test cases are created so that, for the given input, there are fewer than 150 possible combinations that add up to the target.
If there is no possible subsequences then return empty vector.
 */

import java.util.ArrayList;
import java.util.List;

/*
Every time you have N choice (since you can use number repeatedly), and you can choose at most target times (actually it's smaller than target), so we can assume the worst-case time complexity is O(N^target).
 */
public class CombinationSum {
    private static void findTargetSum(int[] candidates, int startIndex, int target, List<List<Integer>> ans, List<Integer> result) {
        if (target == 0) {
            ans.add(new ArrayList<>(result));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            result.add(candidates[i]);//pick the element
            findTargetSum(candidates, i, target - candidates[i], ans, result);
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
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ans = combinationSum(candidates, target);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }

    }
}
