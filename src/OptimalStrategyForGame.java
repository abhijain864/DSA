import java.util.Arrays;

public class OptimalStrategyForGame {

    public static void main(String[] args) {
        countMaximum(new int[]{5,3,98,10}, 4);
    }

    static long countMaximum(int[] arr, int n)
    {
        long[][] dp = new long[n][n];
        recurse(arr,0,n-1, Arrays.stream(arr).sum(), dp);
        return dp[0][n-1];
    }

    static long recurse(int[] arr, int i, int j, int sum, long[][] dp) {
        if (i>j || i<0 || j<0 || i>dp.length - 1 || j>dp.length-1) {
            return 0;
        } else if (i == j) {
            dp[i][j] = arr[i];
            return dp[i][j];
        } else  {
            if(dp[i][j]==0) {
                dp[i][j] = sum - (Math.min(recurse(arr, i+1, j, sum-arr[i], dp), recurse(arr, i,j-1, sum-arr[j], dp)));
            }
            return dp[i][j];
        }
    }

}
