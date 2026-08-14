package DynamicProgramming;

/*
Given a 2d integer array named triangle with n rows. Its first row has 1 element and each succeeding row has one more element in it than the row above it.

Return the minimum falling path sum from the first row to the last.

Movement is allowed only to the bottom or bottom-right cell from the current cell.
 */
public class Triangle {
    private static int minTriangleSum(int[][] matrix) {
        int m = matrix.length;
        Integer[][] dp = new Integer[m][m];
        return solve(0, 0, matrix, m, dp);
    }

    private static int solve(int startRow, int startCol, int[][] matrix, int totalRows, Integer[][] dp) {
        if (startRow == totalRows - 1) {
            return matrix[startRow][startCol];
        }
        if (dp[startRow][startCol] != null) {
            return dp[startRow][startCol];
        }
        dp[startRow][startCol] = matrix[startRow][startCol] + Math.min(solve(startRow + 1, startCol, matrix, totalRows, dp),
                solve(startRow + 1, startCol + 1, matrix, totalRows, dp)//bottom-right
        );
        return dp[startRow][startCol];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}, {1, 2}, {1, 2, 4}};
        System.out.println(minTriangleSum(matrix));

    }
}
