package RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Time Complexity: O(m^V * V)  worst case, tighter bound: O(m^V * (V + E))
 *   - At each of the V vertices, we try up to m colors → m^V branching.
 *   - With an adjacency LIST, checking if a color is safe against a vertex's
 *     neighbors costs O(degree(v)), not O(V) — much cheaper than an
 *     adjacency matrix when the graph is sparse (E << V^2).
 *   - Summed across all vertices in a branch, safety-checking costs O(V + E)
 *     rather than O(V^2), since we only visit each vertex's actual neighbors.
 *
 * Space Complexity: O(V + E)
 *   - O(V) for the recursion call stack (one call per vertex in the worst case).
 *   - O(V) for the color[] array tracking each vertex's assigned color.
 *   - Adjacency list itself is O(V + E) — counted as input representation,
 *     not auxiliary space, same convention as the matrix case.
 *
 * Note: Adjacency list gives a real practical speedup over adjacency matrix
 * specifically for SPARSE graphs (E much smaller than V^2). For DENSE graphs
 * (E close to V^2), the two representations converge to roughly the same
 * cost, since almost every vertex is a neighbor of almost every other.
 */
public class MColoringProblem {
    private static boolean isSafe(int color, int node, int[] colors, List<List<Integer>> adj) {
        for (int neighbor : adj.get(node)) {
            if (colors[neighbor] == color) return false;
        }
        return true;
    }

    private static boolean solve(int node, int totalColors, int totalNodes, int[] colors, List<List<Integer>> adj) {
        if (node == totalNodes) return true;
        for (int i = 1; i <= totalColors; i++) {
            if (isSafe(i, node, colors, adj)) {
                colors[node] = i;
                if (solve(node + 1, totalColors, totalNodes, colors, adj)) return true;
            }
        }
        return false;
    }

    private static boolean canBeColored(int[][] edges, int m, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] colors = new int[n];
        return solve(0, m, n, colors, adj);
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {1, 3}};
        int m = 3;//no of colors
        int n = 4;//no of nodes
        if (canBeColored(edges, m, n)) {
            System.out.println("The graph can be colored with " + m + " colors");
        } else {
            System.out.println("The graph cannot be colored with " + m + " colors");
        }

    }
}
