public class GFG_PartitionEqualSubsetSum {

    public static void main(String[] args) {

    }

    static int equalPartition(int N, int arr[])
    {
        int sum=0;
        for (int i=0;i<N;i++){
            sum+=arr[i];
        }
        int find = sum/2;
        if(dpFunc(find, arr, N)) {
            return 1;
        } else {
            return 0;
        }
    }

    static boolean dpFunc(int find, int arr[], int N){
        boolean dp[][] = new boolean[N+1][find+1];
        for (int i=0;i<N+1;i++){
            for (int j=0; j<find+1; j++){
                if(j==0) {
                    dp[i][j]=true;
                } else if (i == 0) {
                    dp[i][j]=false;
                } else if(arr[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][find];
    }
}
