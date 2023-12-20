package Graphs;

import java.util.ArrayList;

/* 68 out of 69 test cases passes in GFG */
/* Time complexity : O(E*V) */
public class BellmanFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] minDist = new int[V];
        for (int i=0; i<V; i++) {
            minDist[i] = (int) 1e8;
        }
        minDist[S] = 0;
        for (int j=1; j<V; j++) {
            for (ArrayList<Integer> edge : edges) {
                if (minDist[edge.get(0)] + edge.get(2) < minDist[edge.get(1)]) {
                    minDist[edge.get(1)] = minDist[edge.get(0)] + edge.get(2);
                }
            }
        }
        for (ArrayList<Integer> edge : edges) {
            if (minDist[edge.get(0)] + edge.get(2) < minDist[edge.get(1)]) {
                return new int[]{-1};
            }
        }
        return minDist;
    }
}
