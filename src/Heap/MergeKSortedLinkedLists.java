package Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    static class Node
    {
        int data;
        Node next;

        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    Node mergeKList(Node[] arr,int K)
    {
        Node root = null, tail = null;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.data));
        pq.addAll(Arrays.asList(arr));
        while (pq.size() > 0) {
            Node popped = pq.poll();
            if (root==null) {
                root = popped;
                tail = popped;
            } else {
                tail.next = popped;
                tail = tail.next;
            }
            if (popped.next!=null) {
                pq.add(popped.next);
            }
        }
        return root;
    }
}
