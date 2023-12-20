import java.util.Arrays;

public class GFG_LongestIncreasingSubsequenceNLogN {

    /* This approach is NLOG(N) solution for longest increasing subsequence */
    static int longestSubsequence(int size, int a[])
    {
        int[] ans = new int[size+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            int upperBound = upperBound(a[i], ans);
            ans[upperBound] = a[i];
        }
        int length = 1;
        while (length < size && ans[length+1] != Integer.MAX_VALUE) {
            length++;
        }
        return length;
    }

    static int upperBound(int target, int[] arr) {
        int index = Arrays.binarySearch(arr, target);
        return index < 0 ? -index -1 : index ;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence(12, new int[]{10, 10, 9, 8, 4, 8, 10, 4, 5, 12, 12, 7}));
    }

}
