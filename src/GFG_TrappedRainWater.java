import java.util.Stack;

public class GFG_TrappedRainWater {

    public static void main(String[] args) {
        trappingWater(new int[]{8,8,2,4,5,5, 1}, 2);
    }

    static long trappingWater(int arr[], int n) {
        long sum=0;
        // At any given index, find the largest element to the right and the largest element to the left
        int[] lel = new int[arr.length];
        int[] ler = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i==0) lel[i] = arr[i];
            else {
                lel[i] = Math.max(arr[i], lel[i - 1]);
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length-1) ler[i] = arr[i];
            else {
                ler[i] = Math.max(arr[i], ler[i+1] );
            }
        }

        for (int i=1;i< arr.length-1;i++) {
            if (lel[i-1] > arr[i] && ler[i+1] > arr[i]) {
                sum += Math.min(lel[i - 1], ler[i + 1]) - arr[i];
            }
        }
        return sum;
    }


}
