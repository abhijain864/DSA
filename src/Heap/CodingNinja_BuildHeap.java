package Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class CodingNinja_BuildHeap {

    public static void main(String[] args) {
        buildHeap(new ArrayList<>(Arrays.asList(1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17)),11);
    }

    /* This is heapify algorithm, its time complexity is O(N) yes that's correct, try to derive it or search the web how is the complexity O(N)*/

    public static ArrayList<Integer> buildHeap(ArrayList<Integer> arr, int n) {
        for (int i= arr.size()-1; i>=0; i--) {
            heapify(arr, i);
        }
        return arr;
    }

    private static void heapify(ArrayList<Integer> arr, int idx) {
        if (idx < arr.size()) {
            int j = 2*idx+1, k = 2*idx+2;
            if (j < arr.size()) {
                int maxChildIdx = j;
                if (k < arr.size() && arr.get(k) > arr.get(j)) maxChildIdx = k;
                if (arr.get(idx) < arr.get(maxChildIdx)) {
                    int temp = arr.get(idx);
                    arr.set(idx, arr.get(maxChildIdx));
                    arr.set(maxChildIdx, temp);
                    heapify(arr, maxChildIdx);
                }
            }
        }
    }
}
