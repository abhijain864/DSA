package DP;

public class OptimalStrategyForGame {

    public static void main(String[] args) {
        System.out.println(countMaximumdp(new int[]{8, 15, 3, 7}, 4));
        System.out.println(countMaximumdp(new int[]{5, 3, 7, 10}, 4));
    }

    /* * * recursive code, convert it to dp one * * */
    static long countMaximum(int arr[], int n)
    {
        int[] cumSum = new int[arr.length + 1];
        for (int i=1; i<cumSum.length; i++) {
            cumSum[i] = cumSum[i-1] + arr[i-1];
        }
        return findMax(arr, 0, arr.length - 1, cumSum);
    }
    static long findMax(int[] arr, int l, int r, int[] cumSum) {
        if (l==r) {
            return arr[l];
        }
        return cumSum[r+1]-cumSum[l] - Math.min(findMax(arr, l+1, r, cumSum), findMax(arr, l, r-1, cumSum));
    }

    /* * This is the memoized code * */
    static long countMaximumdp(int arr[], int n)
    {
        long dp[][] = new long[n][n];
        for (int i=0; i<n; i++) {
            dp[i][i] = arr[i];
        }
        long[] cumSum = new long[arr.length + 1];
        for (int i=1; i<cumSum.length; i++) {
            cumSum[i] = cumSum[i-1] + arr[i-1];
        }
        return findMaxdp(arr, 0, arr.length - 1, cumSum, dp);
    }
    static long findMaxdp(int[] arr, int l, int r, long[] cumSum, long[][] dp) {
        if (dp[l][r]!=0) return dp[l][r];
        long ans = cumSum[r+1]-cumSum[l] - Math.min(findMaxdp(arr, l+1, r, cumSum, dp), findMaxdp(arr, l, r-1, cumSum, dp));
        dp[l][r] = ans;
        return ans;
    }

}
