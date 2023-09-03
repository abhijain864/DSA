public class GFG_MinNumberOfJumps {

    public static void main(String[] args) {
        minJumps(new int[] {2, 3, 1, 1, 2, 4, 2, 0, 1, 1});
    }

    static int minJumps(int[] arr){
        int dp[] = new int[arr.length];
        dp[arr.length-1] = 0;
        for (int i=arr.length-2; i>=0; i--) {
            if (arr[i]==0) {
                dp[i] = -1;
            }
            else if (i + arr[i] >= arr.length - 1) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                boolean processed = false;
                for (int j=1; j<=arr[i]; j++) {
                    if (dp[i+j]!=-1) {
                        min = Math.min(min, dp[i+j]);
                        processed = true;
                    }
                }
                if (processed) {
                    dp[i] = min + 1;
                } else {
                    dp[i] = -1;
                }
            }
        }
        return dp[0];
    }
}
