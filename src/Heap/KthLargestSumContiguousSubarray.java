package Heap;

import java.util.PriorityQueue;

public class KthLargestSumContiguousSubarray {

    /* Approach 1. Simple calculate all the subarray sums and store it in a list.
    *   Now simple sort them, and return the Kth largest. This approach will take O(N^2 * Log(N)) Time , and O(N^2) Space
    * */

    /* Approach 2. Better solution
    *  Simply make a minHeap. Put the first K subarray sums in the heap, Now in the remaining subarrays, check if that sum
    * is larget than our root node, if yes then pop the current root and insert this sum. The intuition is that we are maintaining
    * K largest subArraySums, at any given time. Here our time will remain same O(N^2 *Log(N)), but only O(K) space required.
    * */

    public static int kthLargest(int N, int K, int[] Arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0;i< Arr.length;i++) {
            int sum = 0;
            for (int j=i;j<N;j++) {
                sum+=Arr[i];
                if (minHeap.size() < K) {
                    minHeap.add(sum);
                } else {
                    if (sum > minHeap.peek()) {
                        minHeap.poll();
                        minHeap.add(sum);
                    }
                }
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {

    }
}

