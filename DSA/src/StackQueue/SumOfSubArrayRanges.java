package StackQueue;

import java.util.Stack;

public class SumOfSubArrayRanges {
    private static int[] NextSmallestFromLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private static int[] NextSmallestFromRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private static int[] NextLargestFromLeft(int[] arr) {
        int n = arr.length;
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private static int[] NextLargestFromRight(int[] arr) {
        int n = arr.length;
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private static int findSumOfSubArrayMinimums(int[] arr) {
        int[] left = NextSmallestFromLeft(arr);
        int[] right = NextSmallestFromRight(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int startingPoint = i - left[i];
            int endingPoint = right[i] - i;
            sum += (arr[i] * startingPoint * endingPoint);
        }
        return sum;
    }

    private static int findSumOfSubArrayMaximums(int[] arr) {
        int[] left = NextLargestFromLeft(arr);
        int[] right = NextLargestFromRight(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int startingPoint = i - left[i];
            int endingPoint = right[i] - i;
            sum += (arr[i] * startingPoint * endingPoint);
        }
        return sum;
    }

    private static int findSumOfSubArrayRanges(int[] arr) {
        int sumOfSubArrayMinimums = findSumOfSubArrayMinimums(arr);
        int sumOfSubArrayMaximums = findSumOfSubArrayMaximums(arr);
        return sumOfSubArrayMaximums - sumOfSubArrayMinimums;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(findSumOfSubArrayRanges(arr));
    }
}
