package RecursionBackTracking;

import java.util.List;
import java.util.ArrayList;

/*
Between n characters, there are n-1 "gaps" where you could choose to cut or not cut. Each gap is an independent binary choice — cut, or don't. That gives:
2^(n-1) possible partitions total
This is the same combinatorial shape as "generate all subsets" — because choosing where to cut is choosing a subset of the gaps.
Layering in the palindrome check cost
At each step of the recursion, before you even recurse, you check whether the current substring is a palindrome — a naive check costs up to O(n) (scanning inward from both ends). Since this check happens at every node of the recursion tree, and the tree has up to 2^n nodes, the commonly cited bound is:

Time Complexity:O(n * 2^n)
Space Complexity
 */
public class PalindromePartitioning {
    private static List<List<String>> findPartitions(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, s, path, result);
        return result;
    }

    private static void dfs(int index, String s, List<String> path, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String prefix = s.substring(index, i + 1);
            if (isPalindrome(prefix)) {
                path.add(prefix);
                dfs(i + 1, s, path, result);
                path.remove(path.size() - 1);
            }
        }

    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaaba";
        List<List<String>> result = findPartitions(s);
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
