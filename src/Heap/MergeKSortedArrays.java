package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    public static void main(String[] args) {
        mergeKArrays(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 3);
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return Integer.compare(
                        arr[node1.getListNum()][node1.getIdx()],
                        arr[node2.getListNum()][node2.getIdx()]
                );
            }
        });
        for (int i=0; i<K; i++) {
            pq.add(new Node(i, 0));
        }
        while (pq.size() > 0) {
            Node popped = pq.poll();
            ans.add(arr[popped.getListNum()][popped.getIdx()]);
            if (popped.getIdx() + 1 < K) {
                pq.add(new Node(popped.getListNum(), popped.getIdx() + 1));
            }
        }
        return ans;
    }

    static class Node {
        int listNum;
        int idx;

        public Node(int listNum, int idx) {
            this.listNum = listNum;
            this.idx = idx;
        }

        public int getListNum() {
            return listNum;
        }

        public void setListNum(int listNum) {
            this.listNum = listNum;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }
    }

}
