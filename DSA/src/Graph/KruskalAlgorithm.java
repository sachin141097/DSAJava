package Graph;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/*
O(ElogE)
 */
class DisSet {
    int[] parent;
    int[] rank;

    DisSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private int findUltimateParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findUltimateParent(parent[node]);
        return parent[node];
    }

    public boolean find(int u, int v) {
        return findUltimateParent(u) == findUltimateParent(v);
    }

    public void unionByRank(int u, int v) {
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);
        if (ultimateParent_u == ultimateParent_v) {
            return;
        }
        if (rank[ultimateParent_u] < rank[ultimateParent_v]) {
            parent[ultimateParent_u] = ultimateParent_v;
        } else if (rank[ultimateParent_v] < rank[ultimateParent_u]) {
            parent[ultimateParent_v] = ultimateParent_u;
        } else {
            rank[ultimateParent_u]++;
            parent[ultimateParent_v] = ultimateParent_u;
        }
    }
}

public class KruskalAlgorithm {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }


    private static void kruskal(int n, List<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.weight));
        DisSet ds = new DisSet(n);
        int minimumSpanningTreeWeight = 0;
        int edgesUsed = 0;
        for (Edge edge : edges) {
            if (!ds.find(edge.src, edge.dest)) {
                minimumSpanningTreeWeight += edge.weight;
                ds.unionByRank(edge.src, edge.dest);
                edgesUsed++;
                if (edgesUsed == n - 1) break;
            }
        }
        if (edgesUsed != n - 1) {
            System.out.println("MST does not exist; graph is disconnected.");
        } else {
            System.out.println("Total MST weight: " + minimumSpanningTreeWeight);
        }

    }

    public static void main(String[] args) {
        int n = 4;//Number of vertices 0,1,2,3
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));
        kruskal(n, edges);
    }
}
