package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Consumer;

public class MinCostOfRopes_UsingPriorityQueue {

    long minCost(long arr[], int n)
    {
        long sum = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Arrays.stream(arr).forEach( value -> minHeap.add(value));

        while (minHeap.size()!=1) {
            Long a = minHeap.poll();
            Long b = minHeap.poll();
            sum+= a+b;
            minHeap.add(a+b);
        }

        return sum;
    }
}
