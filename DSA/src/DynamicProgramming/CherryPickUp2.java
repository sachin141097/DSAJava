package DynamicProgramming;

/*
    CHERRY PICKUP II - DP APPROACH

    Alice starts at (0, 0)
    Bob starts at (0, cols - 1)

    Both move DOWN one row at every step.

    ----------------------------------------------------
    1. DP STATE
    ----------------------------------------------------

    solve(row, aliceCol, bobCol)

    means:

    "What is the maximum number of cherries Alice and Bob
     can collect starting from this row, when Alice is at
     aliceCol and Bob is at bobCol?"

    We don't need aliceRow and bobRow separately because
    both always move to the next row together.

    Therefore:

    dp[row][aliceCol][bobCol]

    ----------------------------------------------------
    2. CURRENT CHERRIES
    ----------------------------------------------------

    If Alice and Bob are on different cells:

        current =
            matrix[row][aliceCol] +
            matrix[row][bobCol]

    If they are on the SAME cell:

        current =
            matrix[row][aliceCol]

    because we cannot count the same cherry twice.

    ----------------------------------------------------
    3. MOVEMENTS
    ----------------------------------------------------

    From any cell, each person has 3 choices:

        LEFT   -> col - 1
        SAME   -> col
        RIGHT  -> col + 1

    Alice has 3 choices.
    Bob has 3 choices.

    Therefore:

        3 × 3 = 9 possible combinations.

    For example:

             Bob
           L   S   R

        L  L,L L,S L,R
    Alice
        S  S,L S,S S,R

        R  R,L R,S R,R


    We try all valid combinations and take the MAXIMUM
    because this is a maximum cherries problem.

    ----------------------------------------------------
    4. RECURRENCE
    ----------------------------------------------------

    solve(row, aliceCol, bobCol)

        =
        current cherries
        +
        maximum of all 9 possible next states

    Example:

        solve(row + 1,
              aliceCol - 1,
              bobCol + 1)

    means:

        Alice -> LEFT
        Bob   -> RIGHT

    ----------------------------------------------------
    5. BOUNDARY
    ----------------------------------------------------

    If a movement takes either person outside the matrix,
    that movement is invalid and should not be considered.

    ----------------------------------------------------
    6. BASE CASE
    ----------------------------------------------------

    When we reach the last row:

        row == rows - 1

    there is no next row.

    Just collect the cherries at Alice's and Bob's
    positions (count once if they are on the same cell).

    ----------------------------------------------------
    7. MEMOIZATION
    ----------------------------------------------------

    Many different paths can reach the same state:

        (row, aliceCol, bobCol)

    Once we calculate that state, store it in:

        dp[row][aliceCol][bobCol]

    If we encounter the same state again, return the
    stored answer instead of calculating it again.

    ----------------------------------------------------
    8. INITIAL STATE
    ----------------------------------------------------

    Alice starts at column 0.
    Bob starts at the last column.

        solve(0, 0, cols - 1)

    ----------------------------------------------------
    9. COMPLEXITY
    ----------------------------------------------------

    Number of states:

        rows × cols × cols

        = O(rows × cols²)

    Each state has at most 9 transitions.

    9 is constant, therefore:

        Time  = O(rows × cols²)
        Space = O(rows × cols²)
*/
public class CherryPickUp2 {
    private static int cherryPickUp2(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Integer[][][] dp = new Integer[rows][cols][cols];
        //Alice starts at (0,0)
        //Bob starts at (0,cols-1)
        return solve(0, 0, cols - 1, matrix, dp, rows, cols);
    }

    private static int solve(int row, int aliceCol, int bobCol, int[][] matrix, Integer[][][] dp, int totalRows, int totalCols) {
        //Last row:collect cherries and stop
        if (row == totalRows - 1) {
            if (aliceCol == bobCol) {
                //same cell count only once
                return matrix[row][aliceCol];
            }
            return matrix[row][aliceCol] + matrix[row][bobCol];
        }
        //Already calculated
        if (dp[row][aliceCol][bobCol] != null) {
            return dp[row][aliceCol][bobCol];
        }
        //current row's cherries
        int currentCherries;
        if (aliceCol == bobCol) {
            currentCherries = matrix[row][bobCol];
        } else {
            currentCherries = matrix[row][aliceCol] + matrix[row][bobCol];
        }
        int maxFuture = 0;
        /*
         * Alice LEFT, Bob LEFT
         */
        if (aliceCol - 1 >= 0 && bobCol - 1 >= 0) {
            maxFuture = Math.max(
                    maxFuture,
                    solve(row + 1,
                            aliceCol - 1,
                            bobCol - 1,
                            matrix, dp, totalRows, totalCols)
            );
        }

        /*
         * Alice LEFT, Bob SAME
         */
        if (aliceCol - 1 >= 0) {
            maxFuture = Math.max(
                    maxFuture,
                    solve(row + 1,
                            aliceCol - 1,
                            bobCol,
                            matrix, dp, totalRows, totalCols)
            );
        }

        /*
         * Alice LEFT, Bob RIGHT
         */
        if (aliceCol - 1 >= 0 && bobCol + 1 < totalCols) {
            maxFuture = Math.max(
                    maxFuture,
                    solve(row + 1,
                            aliceCol - 1,
                            bobCol + 1,
                            matrix, dp, totalRows, totalCols)
            );
        }

        /*
         * Alice SAME, Bob LEFT
         */
        if (bobCol - 1 >= 0) {
            maxFuture = Math.max(
                    maxFuture,
                    solve(row + 1,
                            aliceCol,
                            bobCol - 1,
                            matrix, dp, totalRows, totalCols)
            );
        }

        /*
         * Alice SAME, Bob SAME
         */
        maxFuture = Math.max(
                maxFuture,
                solve(row + 1,
                        aliceCol,
                        bobCol,
                        matrix, dp, totalRows, totalCols)
        );

        /*
         * Alice SAME, Bob RIGHT
         */
        if (bobCol + 1 < totalCols) {
            maxFuture = Math.max(
                    maxFuture,
                    solve(row + 1,
                            aliceCol,
                            bobCol + 1,
                            matrix, dp, totalRows, totalCols)
            );
        }

        /*
         * Alice RIGHT, Bob LEFT
         */
        if (aliceCol + 1 < totalCols && bobCol - 1 >= 0) {
            maxFuture = Math.max(
                    maxFuture,
                    solve(row + 1,
                            aliceCol + 1,
                            bobCol - 1,
                            matrix, dp, totalRows, totalCols)
            );
        }

        /*
         * Alice RIGHT, Bob SAME
         */
        if (aliceCol + 1 < totalCols) {
            maxFuture = Math.max(
                    maxFuture,
                    solve(row + 1,
                            aliceCol + 1,
                            bobCol,
                            matrix, dp, totalRows, totalCols)
            );
        }

        /*
         * Alice RIGHT, Bob RIGHT
         */
        if (aliceCol + 1 < totalCols && bobCol + 1 < totalCols) {
            maxFuture = Math.max(
                    maxFuture,
                    solve(row + 1,
                            aliceCol + 1,
                            bobCol + 1,
                            matrix, dp, totalRows, totalCols)
            );
        }
        return dp[row][aliceCol][bobCol] = currentCherries + maxFuture;

    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {4, 2, 5}, {1, 6, 2}, {7, 2, 8}};
        System.out.println(cherryPickUp2(matrix));

    }
}
