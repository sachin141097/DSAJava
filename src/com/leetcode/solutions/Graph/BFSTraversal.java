package com.leetcode.solutions.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    private static void bfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);
        while (!q.isEmpty()) {
            int current = q.poll();
            result.add(current);
            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    private static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfsHelper(i, adj, visited, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {2, 0}, {0, 3}, {4, 5}};
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        ArrayList<Integer> ans = BFS(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
