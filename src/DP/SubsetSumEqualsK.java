package DP;

public class SubsetSumEqualsK {

    // arr -> 5 6 2 3 7 12 1 1 9 21 11 7
    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp = new int[sum+1][arr.length];
        if (arr[0] <= sum) {
            dp[arr[0]][0] = 1;
        }
        for (int s=0; s<=sum; s++) {
            for (int j=1; j<arr.length; j++) {
                if (s==0) dp[s][j] = 1;
                else {
                    int take = arr[j] <= s ? dp[s-arr[j]][j-1] : 0;
                    int notTake = dp[s][j-1];
                    if (take == 1 || notTake == 1) {
                        dp[s][j] = 1;
                    }
                }
            }
        }
        return dp[sum][arr.length - 1] == 1;
    }

    public static void main(String[] args) {
        isSubsetSum(6, new int[]{11,4,4,12,5,2}, 9);
    }

}
