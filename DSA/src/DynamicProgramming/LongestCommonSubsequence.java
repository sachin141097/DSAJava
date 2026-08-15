package DynamicProgramming;

/*
Given two strings str1 and str2, find the length of their longest common subsequence.

A subsequence is a sequence that appears in the same relative order but not necessarily contiguous and a common subsequence of two strings is a subsequence that is common to both strings.
Example 1
Input: str1 = "bdefg", str2 = "bfg"
Output: 3
Explanation: The longest common subsequence is "bfg", which has a length of 3.
Example 2
Input: str1 = "mnop", str2 = "mnq"
Output: 2
Explanation: The longest common subsequence is "mn", which has a length of 2.
 */

/*
Time Complexity: O(M*N)
Space Complexity: O(M*N)
 */
public class LongestCommonSubsequence {
    private static int findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return lcs(0, 0, s1, s2, dp);
    }

    private static int lcs(int i, int j, String s1, String s2, int[][] dp) {
        //base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        //characters match
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + lcs(i + 1, j + 1, s1, s2, dp);
        }
        //characters don't match
        else {
            dp[i][j] = Math.max(lcs(i + 1, j, s1, s2, dp), lcs(i, j + 1, s1, s2, dp));
        }
        return dp[i][j];

    }

    public static void main(String[] args) {
        String s1 = "mnop";
        String s2 = "mnq";
        System.out.println(findLCS(s1, s2));

    }
}
