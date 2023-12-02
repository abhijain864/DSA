package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CodingNinja_FindMedian {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMedian(new int[]{5, 17, 16, 4, 17, 10, 12}, 7)));
    }

    public static int[] findMedian(int[] arr, int n) {
        int[] ans = new int[arr.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i<arr.length; i++) {
            if (maxHeap.size() < minHeap.size()) {
                if (arr[i] <= minHeap.peek()) {
                    maxHeap.add(arr[i]);
                } else {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(arr[i]);
                }
                ans[i] = (maxHeap.peek()+minHeap.peek())/2;
            } else if (maxHeap.size() == minHeap.size()) {
                if (maxHeap.size()!=0) {
                    if (arr[i] < (maxHeap.peek()+minHeap.peek())/2 )  {
                        maxHeap.add(arr[i]);
                        ans[i] = maxHeap.peek();
                    } else {
                        minHeap.add(arr[i]);
                        ans[i] = minHeap.peek();
                    }
                } else {
                    maxHeap.add(arr[i]);
                    ans[i] = arr[i];
                }
            } else {
                if (arr[i] >= maxHeap.peek()) {
                    minHeap.add(arr[i]);
                } else {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(arr[i]);
                }
                ans[i] = (maxHeap.peek()+minHeap.peek())/2;
            }
        }
        return ans;
    }
}
