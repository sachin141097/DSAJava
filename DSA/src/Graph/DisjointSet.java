package Graph;

/*
Time complexity: Both union operations and connectivity checks take nearly O(1) amortized time, more precisely O(α(n)), where α(n) is the inverse Ackermann function.
 */
public class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    //Find the ultimate parent with path compression
    private int findUltimateParent(int node) {
        //base case: if a node is its own parent,it is the root
        //return the root node
        if (node == parent[node]) {
            return node;
        }
        /*
        Path Compression
        Recursively find ultimate parent of this node's parent
        once the root is found directly connect this node to the root
        Example:
        Before: 1->2->3(root)
        After: 1->3(root)
               2->3(root)
         */
        parent[node] = findUltimateParent(parent[node]);
        //Return the ultimate parent(root) of this node
        return parent[node];

    }

    private void unionByRank(int u, int v) {
        int ultimateParent_u = findUltimateParent(u);
        int ultimateParent_v = findUltimateParent(v);
        if (ultimateParent_u == ultimateParent_v) {
            //already in same component
            return;
        }
        if (rank[ultimateParent_u] < rank[ultimateParent_v]) {
            parent[ultimateParent_u] = ultimateParent_v;
        } else if (rank[ultimateParent_v] < rank[ultimateParent_u]) {
            parent[ultimateParent_v] = ultimateParent_u;
        } else {
            parent[ultimateParent_v] = ultimateParent_u;
            rank[ultimateParent_u]++;
        }
    }

    //Check whether u and v belong to the same component
    private boolean find(int u, int v) {
        return findUltimateParent(u) == findUltimateParent(v);
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        System.out.println(ds.find(1, 3));
        System.out.println(ds.find(1, 5));
    }
}
