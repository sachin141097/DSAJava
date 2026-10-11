package Graph;

public class MakeNetworkConnected {
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

        private int findUltimateParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            parent[node] = findUltimateParent(parent[node]);
            return parent[node];
        }
    }

    private static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        DisJointSet ds = new DisJointSet(n);
        for (int[] connection : connections) {
            ds.unionByRank(connection[0], connection[1]);
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUltimateParent(i) == i) {
                components++;
            }
        }
        return components - 1;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] connections = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(makeConnected(n, connections));

    }
}
