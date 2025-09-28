/*
You are given a map of a building, and your task is to count the number of its rooms. The size of the map is n \times m squares, and each square is either floor or wall. You can walk left, right, up, and down through the floor squares.
Input
The first input line has two integers n and m: the height and width of the map.
Then there are n lines of m characters describing the map. Each character is either . (floor) or # (wall).
Output
Print one integer: the number of rooms.
Constraints

1 \le n,m \le 1000

Example
Input:
5 8
########
#..#...#
####.#.#
#..#...#
########

Output:
3
 */
package com.leetcode.solutions.csesGraph;

import java.util.Scanner;

public class CountingRooms {
    private static void dfs(int row, int col, int totalRows, int totalCols, char[][] grid, boolean[][] visited) {
        visited[row][col] = true;
        //Move Up
        if (row - 1 >= 0 && grid[row - 1][col] == '.' && !visited[row - 1][col]) {
            dfs(row - 1, col, totalRows, totalCols, grid, visited);
        }
        //Move Down
        if (row + 1 < totalRows && grid[row + 1][col] == '.' && !visited[row + 1][col]) {
            dfs(row + 1, col, totalRows, totalCols, grid, visited);
        }
        //Move left
        if (col - 1 >= 0 && grid[row][col - 1] == '.' && !visited[row][col - 1]) {
            dfs(row, col - 1, totalRows, totalCols, grid, visited);
        }
        //Move right
        if (col + 1 < totalCols && grid[row][col + 1] == '.' && !visited[row][col + 1]) {
            dfs(row, col + 1, totalRows, totalCols, grid, visited);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();//consume new line after the numbers
        char[][] grid = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
                visited[i][j] = false;
            }
        }
        int totalRooms = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    dfs(i, j, n, m, grid, visited);
                    totalRooms += 1;
                }
            }
        }
        System.out.println(totalRooms);


    }
}
