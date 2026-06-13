package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class LeftRotateByk {
    private static void leftRotate(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    private static void leftRotateKPlaces(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            leftRotate(arr);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        System.out.println("Enter array elements:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter number of rotations:");
        int k = sc.nextInt();
        leftRotateKPlaces(arr, k);
        System.out.println(Arrays.toString(arr));
        sc.close();

    }
}
