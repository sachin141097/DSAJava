package Arrays;

import java.util.Scanner;

public class MaxConsecutiveOnes {
    private static int findMaxConsecutiveOnes(int[] arr, int n) {
        int count = 0;
        int maxConsecutiveCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
            } else {
                count = 0;
            }
            maxConsecutiveCount = Math.max(maxConsecutiveCount, count);
        }
        return maxConsecutiveCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMaxConsecutiveOnes(arr, n));
        sc.close();
    }
}
