package StackQueue;

import java.util.Stack;

public class CelebrityProblem {
    private static int findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        int rows = arr.length;
        for (int i = 0; i < rows; i++) {
            st.push(i);
        }
        while (st.size() >= 2) {
            int person1 = st.pop();
            int person2 = st.pop();
            if (arr[person1][person2] == 1) {
                //person1 knows person2 so person1 can't be celebrity
                st.push(person2);
            } else {
                //person1 doesn't know person2 so person2 can't be celebrity
                st.push(person1);
            }
        }
        int potential = st.pop();
        for (int i = 0; i < rows; i++) {
            if (i != potential) {
                if (arr[i][potential] == 0 || arr[potential][i] == 1) {
                    return -1;
                }
            }
        }
        return potential;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0}, {0, 0, 0, 0}, {1, 1, 0, 0}, {0, 1, 1, 0}};
        System.out.println(findCelebrity(arr));
    }
}
