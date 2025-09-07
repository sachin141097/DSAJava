package com.leetcode.solutions.Graph;

import java.util.ArrayList;

public class DetectCycleUndirectedGraph {
    private static boolean hasCycleUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycleUtil(neighbor, adj, visited, node)) return true;
            }
            // If an adjacent vertex is visited and
            // is not parent of current vertex,
            // then there exists a cycle in the graph.
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, adj, visited, -1)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {3, 4}};
        if (hasCycle(V, edges)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
