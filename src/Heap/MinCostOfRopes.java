package Heap;

public class MinCostOfRopes {

    public static void main(String[] args) {
        new MinCostOfRopes().minCost(new long[]{4,3,2,6}, 4);
    }

    long minCost(long arr[], int n)
    {
        // make a min heap
        heapify(arr, n);
        long sum = 0;
        while (n!=1) {
            long firstRope = arr[0];
            arr[0] = arr[n-1];
            heapifyNode(arr, --n, 0);
            long secondRope = arr[0];
            arr[0] = arr[n-1];
            heapifyNode(arr, --n, 0);
            sum+= firstRope+secondRope;
            arr[n] = firstRope+secondRope;
            n++;
            heapifyNode(arr,n, n-1);
        }
        return sum;
    }

    private void heapify(long arr[], int n) {
        for (int i=n-1; i>=0; i--) {
            heapifyNode(arr, n, i);
        }
    }

    private void heapifyNode(long arr[], int n, int idx) {
        if (2*idx+1 < n) {
            int minElemIdx = 2*idx+1;
            if (2*idx+2 < n && arr[2*idx+2] < arr[2*idx+1]) {
                minElemIdx = 2*idx+2;
            }
            if (arr[idx] > arr[minElemIdx]) {
                long temp = arr[idx];
                arr[idx] = arr[minElemIdx];
                arr[minElemIdx] = temp;
                heapifyNode(arr, n, minElemIdx);
            }
        }
    }
}
