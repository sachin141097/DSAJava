package DynamicProgramming;

public class BestTimeToBuyAndSellStock4 {

    private static int stockBuySell4(int[] arr, int k) {

        int n = arr.length;

        // dp[index][canBuy][transactions]
        int[][][] dp = new int[n][2][k + 1];

        // Initialize DP with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int t = 0; t <= k; t++) {
                    dp[i][j][t] = -1;
                }
            }
        }

        // Start from day 0
        // canBuy = 1 because we don't own a stock
        // transactions = k
        return maxProfit(arr, 0, 1, k, dp);
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

            // Skip buying today
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
            // One transaction is completed after selling
            int sell = arr[index]
                    + maxProfit(
                    arr,
                    index + 1,
                    1,
                    totalTransactions - 1,
                    dp
            );

            // Skip selling today
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

        int[] arr = {3, 2, 6, 5, 0, 3};

        int k = 2;

        System.out.println(stockBuySell4(arr, k));
    }
}