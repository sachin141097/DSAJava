package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

/*
arr1=[1,2,3]
arr2=[1,1,2,5,6]
union=[1,2,3,5,6]
 */
public class UnionOfTwoSortedArrays {
    private static ArrayList<Integer> findUnion(int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                if (result.size() > 0 && result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                } else if (result.size() == 0) {
                    result.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                if (result.size() > 0 && result.get(result.size() - 1) != arr1[i]) {
                    result.add(arr1[i]);
                } else if (result.size() == 0) {
                    result.add(arr1[i]);
                }
                i++;
            } else {
                if (result.size() > 0 && result.get(result.size() - 1) != arr2[j]) {
                    result.add(arr2[j]);
                } else if (result.size() == 0) {
                    result.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < arr1.length) {
            if (result.get(result.size() - 1) != arr1[i]) {
                result.add(arr1[i]);
            }
            i++;
        }
        while (j < arr2.length) {
            if (result.get(result.size() - 1) != arr2[j]) {
                result.add(arr2[j]);
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array 1:");
        int n1 = sc.nextInt();
        System.out.println("Enter value of array 1:");
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter size of array 2:");
        int n2 = sc.nextInt();
        System.out.println("Enter value of array 2:");
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println(findUnion(arr1, arr2));

    }
}
