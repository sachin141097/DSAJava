package DynamicProgramming;

/*
Time Complexity: O(M*N)
 */
public class UniquePaths {
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, m, n, dp);
    }

    private static int solve(int startRow, int startCol, int totalRow, int totalCol, int[][] dp) {
        if (startRow == totalRow - 1 && startCol == totalCol - 1) {
            return 1;
        }
        if (startRow == totalRow || startCol == totalCol) {
            return 0;
        }
        if (dp[startRow][startCol] != -1) {
            return dp[startRow][startCol];
        }
        int moveDownWays = solve(startRow + 1, startCol, totalRow, totalCol, dp);
        int moveRightWays = solve(startRow, startCol + 1, totalRow, totalCol, dp);
        return dp[startRow][startCol] = moveDownWays + moveRightWays;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(uniquePaths(m, n));

    }
}
