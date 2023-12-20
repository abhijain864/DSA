package Graphs;

import java.util.*;

public class DjikstraAlgorithmRevision {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] ans = new int[V];
        Arrays.fill(ans, Integer.MAX_VALUE);
        int[] vis = new int[V];
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node-> node.minDist));
        minHeap.add(new Node(S, 0));
        while (!minHeap.isEmpty()) {
            Node poll = minHeap.poll();
            if (vis[poll.vertex]!=1) {
                ans[poll.vertex] = poll.minDist;
                vis[poll.vertex] = 1;
                for (List<Integer> nbr : adj.get(poll.vertex)) {
                    int vertex = nbr.get(0);
                    int distance = nbr.get(1);
                    if (vis[vertex]!=1) {
                        if (poll.minDist + distance < ans[vertex]) {
                            minHeap.add(new Node(vertex, poll.minDist + distance));
                        }
                    }
                }
            }
        }
        return ans;
    }

    static class Node {
        private int vertex;
        private int minDist;

        public Node(int vertex, int minDist) {
            this.vertex = vertex;
            this.minDist = minDist;
        }
    }

}
