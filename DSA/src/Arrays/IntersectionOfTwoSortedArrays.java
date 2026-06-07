package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class IntersectionOfTwoSortedArrays {
    private static ArrayList<Integer> findIntersection(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                result.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array 1:");
        int n1 = sc.nextInt();
        System.out.println("Enter the value of array 1:");
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter the size of array 2:");
        int n2 = sc.nextInt();
        System.out.println("Enter value of array 2:");
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println(findIntersection(arr1, arr2));
        sc.close();

    }
}
