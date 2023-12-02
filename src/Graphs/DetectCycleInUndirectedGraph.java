package Graphs;

import java.util.ArrayList;

public class DetectCycleInUndirectedGraph {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        for (int i=0; i<V; i++) {
            if (vis[i]!=1) {
                if (dfs(i, adj, vis, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, int[] vis, int par) {
        vis[src] = 1;
        for (int nbr : adj.get(src)) {
            if (vis[nbr]==0) {
                if (dfs(nbr, adj, vis, src)) {
                    return true;
                }
            } else {
                if (nbr!=par) {
                    return true;
                }
            }
        }
        return false;
    }

}
