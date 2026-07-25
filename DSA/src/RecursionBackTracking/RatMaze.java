package RecursionBackTracking;

import java.util.ArrayList;

/*
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1

paths=[DDRDRR,DRDDRR]
Time Complexity: O(4*(rows*cols))
Space Complexity: O(rows*cols)
At every cell we have 4 possibilities up,down,left,right
 */
public class RatMaze {
    private static void find(int[][] grid, int currentRow, int currentCol, int totalRows, int totalCols, StringBuilder path, ArrayList<String> ans, boolean[][] visited) {
        if (currentRow < 0 || currentCol < 0 || currentRow >= totalRows || currentCol >= totalCols || grid[currentRow][currentCol] != 1 || visited[currentRow][currentCol])
            return;
        visited[currentRow][currentCol] = true;
        if (currentRow == totalRows - 1 && currentCol == totalCols - 1) {
            ans.add(path.toString());
            visited[currentRow][currentCol] = false;//this node can appear in different path hence unmarking
            return;
        }
        //To maintain lexicographical path ordering [Down,Left,Right,Up]
        find(grid, currentRow + 1, currentCol, totalRows, totalCols, path.append("D"), ans, visited);
        path.deleteCharAt(path.length() - 1);//backtrack
        find(grid, currentRow, currentCol - 1, totalRows, totalCols, path.append("L"), ans, visited);
        path.deleteCharAt(path.length() - 1);//backtrack
        find(grid, currentRow - 1, currentCol, totalRows, totalCols, path.append("U"), ans, visited);
        path.deleteCharAt(path.length() - 1);//backtrack
        find(grid, currentRow, currentCol + 1, totalRows, totalCols, path.append("R"), ans, visited);
        path.deleteCharAt(path.length() - 1);//backtrack
        visited[currentRow][currentCol] = false;//this node can appear in different path hence unmarking
    }

    private static ArrayList<String> findPaths(int[][] grid) {
        int totalRows = grid.length;
        int totalCols = grid[0].length;
        boolean[][] visited = new boolean[totalRows][totalCols];
        if (grid[0][0] == 0 || grid[totalRows - 1][totalCols - 1] == 0) return new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        find(grid, 0, 0, totalRows, totalCols, sb, ans, visited);
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(findPaths(grid));
    }
}
