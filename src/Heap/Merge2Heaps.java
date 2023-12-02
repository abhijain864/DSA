package Heap;

public class Merge2Heaps {

    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int[] mergedArr = new int[n+m];
        int i = 0;
        for (int num : a) {
            mergedArr[i++] = num;
        }
        for (int num : b) {
            mergedArr[i++] = num;
        }
        for (int j=mergedArr.length-1 ; j>=0; j--) {
            heapify(mergedArr, j);
        }
        return mergedArr;
    }

    private static void heapify(int[] arr, int idx) {
        if (idx < arr.length) {
            int j = 2*idx+1, k = 2*idx+2;
            if (j < arr.length) {
                int maxChildIdx = j;
                if (k < arr.length && arr[k] > arr[j]) maxChildIdx = k;
                if (arr[idx] < arr[maxChildIdx]) {
                    int temp = arr[idx];
                    arr[idx] = arr[maxChildIdx];
                    arr[maxChildIdx] = temp;
                    heapify(arr, maxChildIdx);
                }
            }
        }
    }
}
