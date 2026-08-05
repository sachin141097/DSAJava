package LeetcodePOTD;

/*
You are maintaining a project that has n methods numbered from 0 to n - 1.

You are given two integers n and k, and a 2D integer array invocations, where invocations[i] = [ai, bi] indicates that method ai invokes method bi.

There is a known bug in method k. Method k, along with any method invoked by it, either directly or indirectly, are considered suspicious and we aim to remove them.

A group of methods can only be removed if no method outside the group invokes any methods within it.

Return an array containing all the remaining methods after removing all the suspicious methods. You may return the answer in any order. If it is not possible to remove all the suspicious methods, none should be removed.



Example 1:

Input: n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]

Output: [0,1,2,3]


 */

import java.util.ArrayList;
import java.util.List;

public class RemoveMethodsFromProject {
    private static void dfs(int node, List<List<Integer>> adjList, boolean[] suspicious) {
        suspicious[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!suspicious[neighbor]) {
                dfs(neighbor, adjList, suspicious);
            }
        }
    }

    private static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < invocations.length; i++) {
            adjList.get(invocations[i][0]).add(invocations[i][1]);
        }
        boolean[] suspicious = new boolean[n];
        dfs(k, adjList, suspicious);
        for (int i = 0; i < invocations.length; i++) {
            if (!suspicious[invocations[i][0]] && suspicious[invocations[i][1]]) {
                for (int method = 0; method < n; method++) {
                    ans.add(method);
                }
                return ans;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        int[][] invocations = {{1, 2}, {0, 1}, {3, 2}};
        System.out.println(remainingMethods(n, k, invocations));

    }
}
