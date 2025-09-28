package com.leetcode.solutions.csesGraph;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class CountingRoomsBFS {
    private static class Point {
        int row, col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static void bfs(int i, int j, int n, int m, char[][] grid, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new Point(i, j));
        while (!q.isEmpty()) {
            Point current = q.poll();
            if (current.row - 1 >= 0 && grid[current.row - 1][current.col] == '.' && !visited[current.row - 1][current.col]) {
                visited[current.row - 1][current.col] = true;
                q.add(new Point(current.row - 1, current.col));
            }
            //Move Down
            if (current.row + 1 < n && grid[current.row + 1][current.col] == '.' && !visited[current.row + 1][current.col]) {
                visited[current.row + 1][current.col] = true;
                q.add(new Point(current.row + 1, current.col));
            }
            //Move left
            if (current.col - 1 >= 0 && grid[current.row][current.col - 1] == '.' && !visited[current.row][current.col - 1]) {
                visited[current.row][current.col - 1] = true;
                q.add(new Point(current.row, current.col - 1));
            }
            //Move right
            if (current.col + 1 < m && grid[current.row][current.col + 1] == '.' && !visited[current.row][current.col + 1]) {
                visited[current.row][current.col + 1] = true;
                q.add(new Point(current.row, current.col + 1));
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    bfs(i, j, n, m, grid, visited);
                    totalRooms += 1;
                }
            }
        }
        System.out.println(totalRooms);

    }
}
