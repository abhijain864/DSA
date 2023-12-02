package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> stack = new Stack<>();
        int vis[] = new int[V];
        for (int i=0; i<V; i++) {
            if (vis[i]!=1) {
                dfs(i, adj, vis, stack);
            }
        }
        int[] ans = new int[V];
        for (int i=0; i<V; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> stack) {
        vis[i] = 1;
        for (int nbr : adj.get(i)) {
            if (vis[nbr]!=1) {
                dfs(nbr, adj, vis, stack);
            }
        }
        stack.push(i);
    }
}
