package com.leetcode.solutions.Graph;

import java.util.ArrayList;

public class DFSTraversalDisconnectedGraph {
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int target) {
        adj.get(source).add(target);
        adj.get(target).add(source);
    }

    private static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, ArrayList<Integer> res) {
        visited[node] = true;
        res.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsRec(adj, visited, neighbor, res);
            }
        }
    }

    private static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        //Loop through all vertices to handle disconnected graphs
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfsRec(adj, visited, i, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {2, 0}, {0, 3}, {4, 5}};
        for (int[] edge : edges) {
            addEdge(adj, edge[0], edge[1]);
        }
        ArrayList<Integer> result = DFS(adj);
        for (int num : result) {
            System.out.print(num + " ");
        }

    }
}
