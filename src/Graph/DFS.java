package Graph;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class DFS {
    private static void dfsTraversal(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsTraversal(neighbor, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println("Enter start vertex: ");
        int start = sc.nextInt();
        boolean[] visited = new boolean[n + 1];
        dfsTraversal(start, adj, visited);
        sc.close();

    }
}
