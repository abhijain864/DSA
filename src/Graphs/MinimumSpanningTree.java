package Graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    static int spanningTree(int V, int E, int edges[][]){
        int ans = 0;
        List<List<Node>> adjList = buildAdjList(V, E, edges);
        int[] vis = new int[V];
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));
        minHeap.add(new Node(0, 0));
        while (!minHeap.isEmpty()) {
            Node popped = minHeap.poll();
            if (vis[popped.getVertex()]!=1) {
                ans+=popped.getWeight();
                vis[popped.getVertex()]=1;
                for (Node nbr : adjList.get(popped.getVertex())) {
                    if (vis[nbr.getVertex()]!=1) {
                        minHeap.add(nbr);
                    }
                }
            }
        }
        return ans;
    }

    private static List<List<Node>> buildAdjList(int v, int e, int[][] edges) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i=0; i<v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i=0; i<e; i++) {
            adjList.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
            adjList.get(edges[i][1]).add(new Node(edges[i][0], edges[i][2]));
        }
        return adjList;
    }

    static class Node {
        private int vertex;
        private int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public void setVertex(int vertex) {
            this.vertex = vertex;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

}
