package Graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    private static void dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }

    private static int countProvinces(int[][] adj) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < adj.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                if (i != j && adj[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[adj.length];
        int provinces = 0;
        for (int i = 0; i < adj.length; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, adjList, visited);
            }
        }
        return provinces;
    }

    public static void main(String[] args) {
        int[][] adj = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}};
        System.out.println(countProvinces(adj));
    }
}
