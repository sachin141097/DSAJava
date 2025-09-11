package com.leetcode.solutions.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Kahn's Algorithm
 * This can also be used to detect cycle in directed graph
 * */
public class TopologicalSort {
    private static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        if (result.size() != V) {
            System.out.println("Graph contains a cycle");
            return new ArrayList<>();
        }
        return result;

    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}, {5, 1}, {5, 2}};
        ArrayList<Integer> result = topoSort(V, edges);
        if (!result.isEmpty()) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
    }
}
