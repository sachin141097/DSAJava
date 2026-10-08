package Graph;

import java.util.Scanner;
import java.util.ArrayList;

public class ConnectedComponents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        //Input edges
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int connectedComponents = findConnectedComponenets(V, adj);
        System.out.println(connectedComponents);
    }

    private static int findConnectedComponenets(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int components = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                components++;
            }
        }
        return components;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
