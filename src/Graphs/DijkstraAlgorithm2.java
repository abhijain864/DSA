package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgorithm2 {

    /* This is wrong. please dont see this solution.*/
    /* If you change the value of an element after the element has been inserted into heap, it won't reflect in the heap . */

    /* Time Complexity : O(V*LOG(V) + E*LOG(V)) */
    static int[] dijkstra2(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] minDist = new int[V];
        int[] vis = new int[V];
        Node[] nodesMap = new Node[V];
        PriorityQueue<Node> minHeap = fetchMinHeap(V, S, nodesMap);
        /* Since only V vertices will be in our heap at maximum, this loop runs for V times */
        /* In each iteration one vertex is removed */
        while (!minHeap.isEmpty()) {
            /* This below line extractMin() takes LOG(V) time */
            Node popped = minHeap.poll();
            if (vis[popped.getVertex()]!=1) {
                vis[popped.getVertex()] = 1;
                minDist[popped.getVertex()] = popped.getMinDist();
                /* The below for loop will run for E times */
                for (ArrayList<Integer> nbr : adj.get(popped.getVertex())) {
                    if (vis[nbr.get(0)]!=1) {
                        /* The below line will take LOG(V) time, (it is a decrease key operation in a min heap) */
                        nodesMap[nbr.get(0)].setMinDist(popped.getMinDist() + nbr.get(1));
                    }
                }
            }
        }
        return minDist;
    }

    private static PriorityQueue<Node> fetchMinHeap(int V, int S, Node[] nodesMap) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::getMinDist));
        for (int i = 0; i< V; i++) {
            Node node;
            if (i!= S) {
                node = new Node(i, Integer.MAX_VALUE);
            } else {
                node = new Node(S, 0);
            }
            nodesMap[i] = node;
            minHeap.remove(node);
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
