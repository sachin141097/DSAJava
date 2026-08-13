package DynamicProgramming;

public class MinimumFallingPathSum {
    private static int minimumFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = null;
            }
        }
        //Try out path from every element in first row and find minimum among them
        int minPathValue = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minPathValue = Math.min(minPathValue, solve(0, col, matrix, m, n, dp));

        }
        return minPathValue;
    }

    private static int solve(int startRow, int startCol, int[][] matrix, int totalRows, int totalCols, Integer[][] dp) {
        if (startRow < 0 || startCol >= totalCols) {
            return Integer.MAX_VALUE;
        }
        if (startRow == totalRows - 1) {
            return matrix[startRow][startCol];
        }
        if (dp[startRow][startCol] != null) {
            return dp[startRow][startCol];
        }
        dp[startRow][startCol] = matrix[startRow][startCol] + Math.min(solve(startRow + 1, startCol, matrix, totalRows, totalCols, dp),//bottom
                Math.min(solve(startRow + 1, startCol - 1, matrix, totalRows, totalCols, dp),//bottom-left
                        solve(startRow + 1, startCol + 1, matrix, totalRows, totalCols, dp))//bottom-right
        );
        return dp[startRow][startCol];
    }

    public static void main(String[] args) {
        int[][] matrix = {{-19, 57}, {-40, -5}};
        System.out.println(minimumFallingPathSum(matrix));
    }
}
