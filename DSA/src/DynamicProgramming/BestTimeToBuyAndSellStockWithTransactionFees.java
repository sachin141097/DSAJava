package DynamicProgramming;

public class BestTimeToBuyAndSellStockWithTransactionFees {

    private static int stockBuySell(int[] arr, int fee) {

        int n = arr.length;

        // dp[index][canBuy]
        int[][] dp = new int[n][2];

        // Initialize DP with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }

        // Start from day 0
        // canBuy = 1 because we don't own a stock
        return maxProfit(arr, 0, 1, fee, dp);
    }

    private static int maxProfit(
            int[] arr,
            int index,
            int canBuy,
            int fee,
            int[][] dp) {

        // No more days
        if (index == arr.length) {
            return 0;
        }

        // Already calculated
        if (dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }

        if (canBuy == 1) {

            // Buy today's stock
            int buy = -arr[index]
                    + maxProfit(
                    arr,
                    index + 1,
                    0,
                    fee,
                    dp
            );

            // Skip buying today
            int skip = maxProfit(
                    arr,
                    index + 1,
                    1,
                    fee,
                    dp
            );

            dp[index][canBuy] = Math.max(buy, skip);

        } else {

            // Sell today's stock
            // Transaction fee is applied when selling
            int sell = arr[index] - fee
                    + maxProfit(
                    arr,
                    index + 1,
                    1,
                    fee,
                    dp
            );

            // Skip selling today
            int skip = maxProfit(
                    arr,
                    index + 1,
                    0,
                    fee,
                    dp
            );

            dp[index][canBuy] = Math.max(sell, skip);
        }

        return dp[index][canBuy];
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 0, 2};

        int fee = 1;

        System.out.println(stockBuySell(arr, fee));
    }
}