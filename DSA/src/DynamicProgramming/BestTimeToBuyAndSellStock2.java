package DynamicProgramming;

public class BestTimeToBuyAndSellStock2 {
    private static int stockBuySell2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return maxProfit(arr, 0, 1, dp);
    }

    private static int maxProfit(int[] arr, int index, int canBuy, int[][] dp) {
        if (index == arr.length) {
            return 0;
        }
        if (dp[index][canBuy] != -1) {
            return dp[index][canBuy];
        }
        if (canBuy == 1) {
            int buy = -arr[index] + maxProfit(arr, index + 1, 0, dp);
            int skip = maxProfit(arr, index + 1, 1, dp);
            dp[index][canBuy] = Math.max(buy, skip);
        } else {
            int sell = arr[index] + maxProfit(arr, index + 1, 1, dp);
            int skip = maxProfit(arr, index + 1, 0, dp);
            dp[index][canBuy] = Math.max(sell, skip);
        }
        return dp[index][canBuy];
    }

    public static void main(String[] args) {
        int[] arr = {8, 6, 5, 4, 3};
        System.out.println(stockBuySell2(arr));
    }
}
