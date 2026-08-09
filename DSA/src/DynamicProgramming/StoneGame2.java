package DynamicProgramming;

import java.util.Arrays;

public class StoneGame2 {
    private static int solve(int[] piles, int person, int index, int M, int n, int[][][] dp) {

        if (index >= n) {
            return 0;
        }

        if (dp[person][index][M] != -1) {
            return dp[person][index][M];
        }

        int result;

        if (person == 1) {
            result = -1;                  // Alice wants maximum
        } else {
            result = Integer.MAX_VALUE;   // Bob wants minimum
        }

        int stones = 0;

        for (int x = 1; x <= Math.min(2 * M, n - index); x++) {

            stones += piles[index + x - 1];

            int newM = Math.max(M, x);

            if (person == 1) {
                // Alice's turn
                result = Math.max(
                        result,
                        stones + solve(piles, 0, index + x, newM, n, dp)
                );
            } else {
                // Bob's turn
                result = Math.min(
                        result,
                        solve(piles, 1, index + x, newM, n, dp)
                );
            }
        }

        return dp[person][index][M] = result;
    }

    private static int stonegame2(int[] piles) {

        int n = piles.length;
        int[][][] dp = new int[2][101][101];
        for (int[][] arr2D : dp) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        // 1 = Alice, 0 = Bob
        return solve(piles, 1, 0, 1, n, dp);
    }

    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        System.out.println(stonegame2(piles));
    }
}
