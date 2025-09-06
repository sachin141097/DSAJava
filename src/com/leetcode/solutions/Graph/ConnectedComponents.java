package com.leetcode.solutions.Graph;

import java.util.ArrayList;

public class ConnectedComponents {
    private static ArrayList<ArrayList<Integer>> buildGraph(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);
        //visit all unvisited neighbors
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = buildGraph(V, edges);
        //to keep track of visited nodes
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                result.add(component);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        //Number of nodes
        int V = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        ArrayList<ArrayList<Integer>> result = getComponents(V, edges);
        for (ArrayList<Integer> component : result) {
            for (int node : component) {
                System.out.print(node + " ");
            }
            System.out.println();

        }
    }
}
