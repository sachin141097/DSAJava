package Graph;

import java.util.Scanner;
import java.util.ArrayList;

/*
Time Complexity: O(V+E)
Space Complexity: O(V) (Recursion space)
 */
public class DFS {
    private static ArrayList<Integer> dfs(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsHelper(0, adj, visited, result);
        return result;
    }

    private static void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input number of vertices and edges
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

            //Undirected graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        ArrayList<Integer> dfsResult = dfs(V, adj);
        System.out.println(dfsResult);
        sc.close();

    }

}
