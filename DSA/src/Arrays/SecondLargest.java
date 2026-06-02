package Arrays;

import java.util.Scanner;

public class SecondLargest {
    private static int findSecondLargest(int[] arr, int n) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];

            } else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findSecondLargest(arr, n));
        sc.close();
    }
}
