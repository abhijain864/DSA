package Graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int recs[] = new int[V];
        for (int i=0; i<V; i++) {
            if (vis[i]!=1) {
                if (dfs(i, adj, vis, recs)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* Check where this is going wrong */
    private boolean dfs2(int src, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] recs) {
        vis[src] = 1;
        recs[src] = 1;
        for (int nbr : adj.get(src)) {
            if (recs[nbr] == 1) {
                return true;
            } else {
                if (dfs(nbr, adj, vis, recs)) {
                    return true;
                }
            }
        }
        recs[src] = 0;
        return false;
    }

    private boolean dfs(int src, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] recs) {
        vis[src] = 1;
        recs[src] = 1;
        for (int nbr : adj.get(src)) {
            if (vis[nbr] != 1) {
                if (dfs(nbr, adj, vis, recs)) {
                    return true;
                }
            } else if(recs[nbr] == 1){
                return true;
            }
        }
        recs[src] = 0;
        return false;
    }


}
