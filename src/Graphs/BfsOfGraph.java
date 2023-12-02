package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BfsOfGraph {

    /* TC : O(2E + V) */
    /* SC : O(V)*/
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        vis[0] = 1;
        /* 1.A:  This while loop runs for each vertex once, hence V times */
        while (!q.isEmpty()) {
            /* 1.B : Hence the below 2 lines will take O(V) time */
            Integer popped = q.poll();
            ans.add(popped);

            /* 2.A : The below for loop, will run for all the neighbours of a particular node. Since each edge
            * denotes a relationship of first node to second, and second node to first the below for loop will
            * run for a total of 2E Times*/
            for (Integer neighbour : adj.get(popped)) {
                /* 2.B: Hence these below lines will take O(2E) times */
                if (vis[neighbour]!=1) {
                    q.add(neighbour);
                    vis[neighbour] = 1;
                }
            }
        }
        return ans;
    }
}
