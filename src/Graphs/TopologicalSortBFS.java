package Graphs;

import java.util.*;

public class TopologicalSortBFS {

    /* This algorithm is known as Kahn's algorithm */
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] sortedAns = new int[V];
        int[] inDegree = buildDegree(V, adj);
        Queue<Integer> q = new ArrayDeque<>();
        initializeQueue(V, inDegree, q);

        int i=0;
        while (!q.isEmpty()) {
            int popped = q.poll();
            sortedAns[i] = popped;
            for (int nbr : adj.get(popped)) {
                inDegree[nbr]--;
                if (inDegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
            i++;
        }

        return sortedAns;
    }

    private static void initializeQueue(int V, int[] inDegree, Queue<Integer> q) {
        for (int i = 0; i< V; i++) {
            if (inDegree[i]==0) {
                q.add(i);
            }
        }
    }

    private static int[] buildDegree(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        /* 1. Find incoming edges count for every node */
        for (int i = 0; i< V; i++) {
            for (int e : adj.get(i)) {
                inDegree[e]++;
            }
        }
        return inDegree;
    }
}
