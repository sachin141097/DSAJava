package Graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    static class DisJointSet {
        int[] parent;
        int[] rank;

        public DisJointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            parent[node] = findUltimateParent(parent[node]);
            return parent[node];
        }

        public void unionByRank(int u, int v) {
            int rootU = findUltimateParent(u);
            int rootV = findUltimateParent(v);
            if (rootU == rootV) {
                return;
            }
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    private static List<Integer> numberOfIslands2(int n, int m, int A[][]) {
        int k = A.length;
        int[][] grid = new int[n][m];
        List<Integer> answer = new ArrayList<>();
        DisJointSet ds = new DisJointSet(n * m);
        int count = 0;
        for (int i = 0; i < k; i++) {
            int r = A[i][0];
            int c = A[i][1];
            if (grid[r][c] == 1) {
                answer.add(count);
                continue;
            }
            grid[r][c] = 1;
            count++;
            int node = r * m + c;
            //Up
            if (r > 0 && grid[r - 1][c] == 1) {
                int neighbor = (r - 1) * m + c;
                int root1 = ds.findUltimateParent(node);
                int root2 = ds.findUltimateParent(neighbor);
                if (root1 != root2) {
                    ds.unionByRank(root1, root2);
                    count--;
                }
            }
            //Down
            if (r < n - 1 && grid[r + 1][c] == 1) {
                int neighbor = (r + 1) * m + c;
                int root1 = ds.findUltimateParent(node);
                int root2 = ds.findUltimateParent(neighbor);
                if (root1 != root2) {
                    ds.unionByRank(root1, root2);
                    count--;
                }
            }
            //Left
            if (c > 0 && grid[r][c - 1] == 1) {
                int neighbor = r * m + c - 1;
                int root1 = ds.findUltimateParent(node);
                int root2 = ds.findUltimateParent(neighbor);
                if (root1 != root2) {
                    ds.unionByRank(root1, root2);
                    count--;
                }
            }
            //Right
            if (c < m - 1 && grid[r][c + 1] == 1) {
                int neighbor = r * m + c + 1;
                int root1 = ds.findUltimateParent(node);
                int root2 = ds.findUltimateParent(neighbor);
                if (root1 != root2) {
                    ds.unionByRank(root1, root2);
                    count--;
                }
            }
            answer.add(count);

        }
        return answer;

    }

    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        int A[][] = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        System.out.println(numberOfIslands2(n, m, A));
    }
}
