package DynamicProgramming;

public class UniquePaths2 {
    private static int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        if (matrix[0][0] == 1 || matrix[m - 1][n - 1] == 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, 0, m, n, dp, matrix);
    }

    private static int solve(int startRow, int startCol, int totalRow, int totalCol, int[][] dp, int[][] matrix) {
        if (startRow == totalRow - 1 && startCol == totalCol - 1) {
            return 1;
        }
        if (startRow == totalRow || startCol == totalCol || matrix[startRow][startCol] == 1) {
            return 0;
        }
        if (dp[startRow][startCol] != -1) {
            return dp[startRow][startCol];
        }
        int moveDownWays = solve(startRow + 1, startCol, totalRow, totalCol, dp, matrix);
        int moveRightWays = solve(startRow, startCol + 1, totalRow, totalCol, dp, matrix);
        return dp[startRow][startCol] = moveDownWays + moveRightWays;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(matrix));
    }
}
