package Arrays;

import java.util.Scanner;

public class FindMissingNumber {
    private static int findMissingNumber(int[] arr, int n) {
        int totalSum = (n * (n + 1)) / 2;
        int currentSum = 0;
        for (int element : arr) {
            currentSum += element;
        }
        return totalSum - currentSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        System.out.println("Enter the value of array elements:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMissingNumber(arr, n));

    }
}
