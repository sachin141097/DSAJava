package DynamicProgramming;

/*
Given an array arr of n integers, where arr[i] represents price of the stock on the ith day. Determine the maximum profit achievable by buying and selling the stock at most once.

The stock should be purchased before selling it, and both actions cannot occur on the same day.
Example 1
Input: arr = [10, 7, 5, 8, 11, 9]
Output: 6
Explanation: Buy on day 3 (price = 5) and sell on day 5 (price = 11), profit = 11 - 5 = 6.
Example 2
Input: arr = [5, 4, 3, 2, 1]
Output: 0

 */
public class BestTimeToBuyAndSellStock {
    private static int stockBuySell1(int[] arr) {
        int n = arr.length;
        int[][][] dp = new int[n][2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return maxProfit(arr, 0, 1, 1, dp);
    }

    private static int maxProfit(int[] arr, int index, int canBuy, int transactions, int[][][] dp) {
        if (index == arr.length || transactions == 0) {
            return 0;
        }
        if (dp[index][canBuy][transactions] != -1) {
            return dp[index][canBuy][transactions];
        }
        if (canBuy == 1) {
            int buy = -arr[index] + maxProfit(arr, index + 1, 0, transactions, dp);
            int skip = maxProfit(arr, index + 1, 1, transactions, dp);
            dp[index][canBuy][transactions] = Math.max(buy, skip);
        } else {
            int sell = arr[index] + maxProfit(arr, index + 1, 1, transactions - 1, dp);
            int skip = maxProfit(arr, index + 1, 0, transactions, dp);
            dp[index][canBuy][transactions] = Math.max(sell, skip);
        }
        return dp[index][canBuy][transactions];
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 1, 4, 6, 2};
        System.out.println(stockBuySell1(arr));
    }
}
