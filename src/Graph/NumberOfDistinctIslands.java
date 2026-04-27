package Graph;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;

public class NumberOfDistinctIslands {
    private static void dfs(int row, int col, boolean[][] visited, int[][] grid, ArrayList<String> vec, int row0, int col0) {
        visited[row][col] = true;
        vec.add(toString(row - row0, col - col0));
        int rows = grid.length;
        int cols = grid[0].length;
        //visit up
        if (row - 1 >= 0 && grid[row - 1][col] == 1 && !visited[row - 1][col]) {
            dfs(row - 1, col, visited, grid, vec, row0, col0);
        }
        //visit down
        if (row + 1 < rows && grid[row + 1][col] == 1 && !visited[row + 1][col]) {
            dfs(row + 1, col, visited, grid, vec, row0, col0);
        }
        //visit left
        if (col - 1 >= 0 && grid[row][col - 1] == 1 && !visited[row][col - 1]) {
            dfs(row, col - 1, visited, grid, vec, row0, col0);
        }
        //visit right
        if (col + 1 < cols && grid[row][col + 1] == 1 && !visited[row][col + 1]) {
            dfs(row, col + 1, visited, grid, vec, row0, col0);
        }

    }

    private static String toString(int r, int c) {
        return r + "," + c;
    }

    private static int distinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<ArrayList<String>> s = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, visited, grid, vec, i, j);
                    s.add(vec);
                }
            }
        }
        return s.size();
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        System.out.println(distinctIslands(grid));
    }
}
