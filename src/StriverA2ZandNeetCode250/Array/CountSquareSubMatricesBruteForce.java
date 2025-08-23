package StriverA2ZandNeetCode250.Array;

/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation:
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

Example 2:

Input: matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation:
There are 6 squares of side 1.
There is 1 square of side 2.
Total number of squares = 6 + 1 = 7.

if it is square matrix time complexity is O(n^5) where n is number of rows and columns

Great question! Let's analyze the time complexity for a general m × n matrix:
Breaking it down:

Outer two loops: O(m × n) - we visit each cell in the m×n matrix
Size expansion loop: For each cell at position (i,j), what's the maximum square size we can form?

We're limited by remaining rows: m - i
We're limited by remaining columns: n - j
Maximum square size = min(m - i, n - j)
In worst case (top-left corner): min(m, n)
So this loop runs O(min(m, n)) times


Inner validation loops: For each square of size s, we check s × s positions

Maximum s is min(m, n)
So worst case is O((min(m, n))²)



Total Time Complexity:
O(m × n) × O(min(m, n)) × O((min(m, n))²)
= O(m × n × (min(m, n))³)
 */
public class CountSquareSubMatricesBruteForce {

    private static int CountSquareSubMatricesWithAllOnes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int subMatricesWithAllOnes = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    //Try expanding from 1*1,2*2,3*3 until we can't
                    for (int size = 1; i + size <= row && j + size <= col; size++) {
                        boolean allOnes = true;
                        //check all positions in current square
                        for (int x = i; x < i + size; x++) {
                            for (int y = j; y < j + size; y++) {
                                if (matrix[x][y] == 0) {
                                    allOnes = false;
                                    break;
                                }
                            }
                            if (!allOnes) break;
                        }
                        if (allOnes) {
                            subMatricesWithAllOnes++;
                        } else {
                            break;
                        }

                    }
                }
            }
        }
        return subMatricesWithAllOnes;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(CountSquareSubMatricesWithAllOnes(arr));

    }
}
