package DynamicProgramming;

/*
A ninja has planned a n-day training schedule. Each day he has to perform one of three activities - running, stealth training, or fighting practice. The same activity cannot be done on two consecutive days and the ninja earns a specific number of merit points, based on the activity and the given day.

Given a n x 3-sized matrix, where matrix[i][0], matrix[i][1], and matrix[i][2], represent the merit points associated with running, stealth and fighting practice, on the (i+1)th day respectively. Return the maximum possible merit points that the ninja can earn.
Example 1
Input: matrix = [[10, 40, 70], [20, 50, 80], [30, 60, 90]]
Output: 210
Explanation:
Day 1: fighting practice = 70
Day 2: stealth training = 50
Day 3: fighting practice = 90
Total = 70 + 50 + 90 = 210
This gives the optimal points.
Example 2
Input: matrix = [[70, 40, 10], [180, 20, 5], [200, 60, 30]]
Output: 290
Explanation:
Day 1: running = 70
Day 2: stealth training = 20
Day 3: running = 200
Total = 70 + 20 + 200 = 290
This gives the optimal points.
 */

/*
Time Complexity: O(days*activities)
 */
public class NinjaTraining {
    private static int findMaximumPoints(int[][] points) {
        //number of days
        int days = points.length;

        //0,1,2-activities
        //3=no previous activity (-1)
        int[][] dp = new int[days][4];
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(0, -1, points, dp);
    }

    private static int solve(int currentDay, int lastActivity, int[][] points, int[][] dp) {
        //All days completed
        if (currentDay == points.length) {
            return 0;
        }
        //convert -1 to 3 for dp indexing
        int last = lastActivity == -1 ? 3 : lastActivity;
        if (dp[currentDay][last] != -1) {
            return dp[currentDay][last];
        }
        int maxi = 0;
        //Try all 3 activities
        for (int activity = 0; activity < 3; activity++) {
            //cannot choose same activity as yesterday
            if (activity != lastActivity) {
                int pointsEarned = points[currentDay][activity] + solve(currentDay + 1, activity, points, dp);
                maxi = Math.max(maxi, pointsEarned);
            }
        }
        return dp[currentDay][last] = maxi;

    }

    public static void main(String[] args) {
        int[][] matrix = {{10, 9, 0}, {100, 0, 0}};
        //greedy doesn't work
        System.out.println(findMaximumPoints(matrix));

    }
}
