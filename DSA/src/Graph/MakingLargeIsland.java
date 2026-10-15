package Graph;

import java.util.HashSet;
import java.util.Set;

/*
Time Complexity: O(n*n)
 */
public class MakingLargeIsland {
    static class DisJointSet {
        int[] parent;
        int[] size;

        public DisJointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int findUltimateParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            parent[node] = findUltimateParent(parent[node]);
            return parent[node];
        }

        public void unionBySize(int u, int v) {
            int rootU = findUltimateParent(u);
            int rootV = findUltimateParent(v);
            if (rootU == rootV) {
                return;
            }
            if (size[rootU] < size[rootV]) {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            } else {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            }
        }
    }

    public static int largeIsland(int[][] grid) {
        int n = grid.length;
        DisJointSet ds = new DisJointSet(n * n);
        //Connect existing land cells
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }
                int node = r * n + c;
                //Up
                if (r > 0 && grid[r - 1][c] == 1) {
                    ds.unionBySize(node, (r - 1) * n + c);
                }
                //Down
                if (r < n - 1 && grid[r + 1][c] == 1) {
                    ds.unionBySize(node, (r + 1) * n + c);
                }
                //Left
                if (c > 0 && grid[r][c - 1] == 1) {
                    ds.unionBySize(node, r * n + c - 1);
                }
                //Right
                if (c < n - 1 && grid[r][c + 1] == 1) {
                    ds.unionBySize(node, r * n + c + 1);
                }
            }
        }
        // Find the largest existing island.
        //
        // Example grid:
        //   1 1
        //   1 0
        //
        // Flattened node IDs (r * n + c):
        //   0 1
        //   2 3
        //
        // Nodes 0, 1, and 2 belong to the same island of size 3.
        // Node 0 is the root, so ds.size[0] = 3.
        // Nodes 1 and 2 are not roots, so we skip them.
        // Node 3 represents water and remains a separate singleton
        // with size 1. Including it does not affect the maximum.
        //
        // We need this loop to find the largest existing island,
        // especially when the grid contains no water cells to flip.
        int maxIsland = 0;
        for (int i = 0; i < n * n; i++) {
            if (ds.findUltimateParent(i) == i) {
                maxIsland = Math.max(maxIsland, ds.size[i]);
            }
        }
        //Try flipping each water cell
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    continue;
                }

                Set<Integer> uniqueRoots = new HashSet<>();
                //Up
                if (r > 0 && grid[r - 1][c] == 1) {
                    uniqueRoots.add(ds.findUltimateParent((r - 1) * n + c));
                }

                //Down
                if (r < n - 1 && grid[r + 1][c] == 1) {
                    uniqueRoots.add(ds.findUltimateParent((r + 1) * n + c));
                }

                //Left
                if (c > 0 && grid[r][c - 1] == 1) {
                    uniqueRoots.add(ds.findUltimateParent(r * n + c - 1));
                }

                //Right
                if (c < n - 1 && grid[r][c + 1] == 1) {
                    uniqueRoots.add(ds.findUltimateParent(r * n + c + 1));
                }

                //Count the flipped cell and each distinct island
                int currentSize = 1;
                for (int root : uniqueRoots) {
                    currentSize += ds.size[root];
                }
                maxIsland = Math.max(maxIsland, currentSize);
            }
        }
        return maxIsland;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 1}};
        int result = largeIsland(grid);
        System.out.println(result);

    }
}
