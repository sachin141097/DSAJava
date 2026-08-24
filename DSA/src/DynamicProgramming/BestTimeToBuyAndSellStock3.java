package DynamicProgramming;

public class BestTimeToBuyAndSellStock3 {

    private static int stockBuySell3(int[] arr) {

        int n = arr.length;

        // dp[index][canBuy][transactions]
        int[][][] dp = new int[n][2][4];

        // Initialize DP with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        // We can buy initially
        // We have at most 2 transactions
        return maxProfit(arr, 0, 1, 2, dp);
    }

    private static int maxProfit(
            int[] arr,
            int index,
            int canBuy,
            int totalTransactions,
            int[][][] dp) {

        // No more days OR no transactions remaining
        if (index == arr.length || totalTransactions == 0) {
            return 0;
        }

        // Already calculated
        if (dp[index][canBuy][totalTransactions] != -1) {
            return dp[index][canBuy][totalTransactions];
        }

        if (canBuy == 1) {

            // Buy today's stock
            int buy = -arr[index]
                    + maxProfit(
                    arr,
                    index + 1,
                    0,
                    totalTransactions,
                    dp
            );

            // Don't buy today
            int skip = maxProfit(
                    arr,
                    index + 1,
                    1,
                    totalTransactions,
                    dp
            );

            dp[index][canBuy][totalTransactions] =
                    Math.max(buy, skip);

        } else {

            // Sell today's stock
            int sell = arr[index]
                    + maxProfit(
                    arr,
                    index + 1,
                    1,
                    totalTransactions - 1,
                    dp
            );

            // Don't sell today
            int skip = maxProfit(
                    arr,
                    index + 1,
                    0,
                    totalTransactions,
                    dp
            );

            dp[index][canBuy][totalTransactions] =
                    Math.max(sell, skip);
        }

        return dp[index][canBuy][totalTransactions];
    }

    public static void main(String[] args) {

        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};

        System.out.println(stockBuySell3(arr));
    }
}