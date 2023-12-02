import java.util.HashMap;

public class GeneralArrayQuestions {

    public static long pairWithMaxSum(long arr[], long N)
    {
        long max = arr[0]+arr[1];
        for (int i = 0; i<arr.length-1; i++) {
            if (arr[i]+arr[i+1] > max) {
                max = arr[i] + arr[i+1];
            }
        }
        return max;
    }

    public static long required(long a[], long n, long k) {
        long max = a[0];
        for (int i=0;i<a.length;i++) {
            if (a[i] > max) max = a[i];
        }
        if (k>max) return -1;
        else return max - k;
    }

    static int isPossible(int N, int arr[], int K)
    {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i=0;i< arr.length;i++) {
            if (!freq.containsKey(arr[i])) {
                freq.put(arr[i],1);
            } else {
                if (freq.get(arr[i])+1 > 2*K) {
                    return 0;
                } else {
                    freq.put(arr[i], freq.get(arr[i])+1);
                }
            }
        }
        return 1;
    }

}
