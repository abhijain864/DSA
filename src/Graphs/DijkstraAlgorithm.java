package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        int[] minDist = new int[V];
        int[] vis = new int[V];
        PriorityQueue<Node> minHeap = fetchMinHeap(V, S);
        while (!minHeap.isEmpty()) {
            Node popped = minHeap.poll();
            if (vis[popped.getVertex()]!=1) {
                vis[popped.getVertex()] = 1;
                minDist[popped.getVertex()] = popped.getMinDist();
                for (ArrayList<Integer> nbr : adj.get(popped.getVertex())) {
                    if (vis[nbr.get(0)]!=1) {
                        minHeap.add(new Node(nbr.get(0), popped.getMinDist() + nbr.get(1)));
                    }
                }
            }
        }
        return minDist;
    }

    private static PriorityQueue<Node> fetchMinHeap(int V, int S) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::getMinDist));
        for (int i = 0; i< V; i++) {
            if (i!= S) {
                minHeap.add(new Node(i, Integer.MAX_VALUE));
            } else {
                minHeap.add(new Node(S, 0));
            }
        }
        return minHeap;
    }

    static class Node {
        private int vertex;
        private int minDist;

        public Node(int vertex, int minDist) {
            this.vertex = vertex;
            this.minDist = minDist;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getMinDist() {
            return minDist;
        }

        public void setMinDist(int minDist) {
            this.minDist = minDist;
        }
    }
}
