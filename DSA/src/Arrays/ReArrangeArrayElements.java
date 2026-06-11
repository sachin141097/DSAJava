package Arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class ReArrangeArrayElements {
    private static int[] reArrangeElements(int[] arr) {
        int[] result = new int[arr.length];
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        for (int num : arr) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }
        for (int i = 0; i < result.length / 2; i++) {
            result[2 * i] = positive.get(i);
            result[2 * i + 1] = negative.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = reArrangeElements(arr);
        System.out.println(Arrays.toString(ans));

    }
}
