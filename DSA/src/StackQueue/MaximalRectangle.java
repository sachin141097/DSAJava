package StackQueue;

import java.util.Stack;

public class MaximalRectangle {
    private static int[] NextSmallestFromLeft(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
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

    private static int[] NextSmallestFromRight(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
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

    private static int findLargestRectangle(int[] height) {
        int n = height.length;
        int maxArea = Integer.MIN_VALUE;
        int[] right = NextSmallestFromRight(height);
        int[] left = NextSmallestFromLeft(height);
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * height[i]);

        }
        return maxArea;
    }

    private static int findMaximumRectangle(int[][] matrix) {
        int area = Integer.MIN_VALUE;
        int[][] prefixedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < prefixedMatrix.length; i++) {
            for (int j = 0; j < prefixedMatrix[0].length; j++) {
                if (i == 0) {
                    prefixedMatrix[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    prefixedMatrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < prefixedMatrix.length; i++) {
            area = Math.max(area, findLargestRectangle(prefixedMatrix[i]));
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(findMaximumRectangle(matrix));
    }
}
