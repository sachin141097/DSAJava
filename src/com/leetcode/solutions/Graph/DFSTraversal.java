package com.leetcode.solutions.Graph;

import java.util.ArrayList;

//This DFS Traversal is for connected undirected graph
public class DFSTraversal {
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int target) {
        //Undirected graph
        adj.get(source).add(target);
        adj.get(target).add(source);
    }

    private static void dfsRec(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsRec(adj, visited, neighbor, result);
            }
        }
    }

    private static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> res = new ArrayList<>();
        dfsRec(adj, visited, 0, res);
        return res;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[][] edges = {{1, 2}, {1, 0}, {2, 0}, {2, 3}, {2, 4}};
        for (int[] edge : edges) {
            addEdge(adj, edge[0], edge[1]);
        }
        ArrayList<Integer> result = DFS(adj);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

    }
}
