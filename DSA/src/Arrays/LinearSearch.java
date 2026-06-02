package Arrays;
/*
Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target appears in the array. If the target is not found in the array, return -1

Example 1

Input: nums = [2, 3, 4, 5, 3], target = 3

Output: 1

Explanation:

The first occurence of 3 in nums is at index 1

Example 2

Input: nums = [2, -4, 4, 0, 10], target = 6

Output: -1

Explanation:

The value 6 does not occur in the array, hence output is -1
 */

/*
Time Complexity: O(N)
 */

import java.util.Scanner;

public class LinearSearch {
    private static int checkElementExist(int[] arr, int n, int target) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of target");
        int target = sc.nextInt();
        int result = checkElementExist(arr, n, target);
        System.out.println(result);
        sc.close();


    }
}
