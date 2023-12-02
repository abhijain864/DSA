package Graphs;

import java.util.ArrayList;

public class PrerequisiteTasks {

    public static void main(String[] args) {
        System.out.println(new PrerequisiteTasks().isPossible(5, 6, new int[][]{{0, 3}, {3, 1}, {1, 4}, {4, 2}, {3, 4}, {4, 1}}));
    }

    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = buildAdjacencyList(N, P, prerequisites);
        // Now cycle detection needs to be done
        int[] vis = new int[N];
        int[] recs = new int[N];
        for (int i=0; i<N; i++) {
            if (vis[i]!=1) {
                if (dfs(i,adj,vis,recs)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] recs) {
        vis[i] = 1;
        recs[i] = 1;
        for (int nbr : adj.get(i)) {
            if (vis[nbr]!=1) {
                if (dfs(nbr, adj, vis, recs)) {
                    return true;
                }
            } else {
                if (recs[nbr]==1) {
                    return true;
                }
            }
        }
        recs[i] = 0;
        return false;
    }

    private static ArrayList<ArrayList<Integer>> buildAdjacencyList(int N, int P, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i= 0; i<N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i< P; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return adj;
    }
}
