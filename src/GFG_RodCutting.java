public class GFG_RodCutting {

    public static void main(String[] args) {

    }

    public int cutRod(int price[], int n) {
        int dp[] = new int[n+1];
        for (int i=0;i<n+1;i++) {
            if (i==0) dp[i] = 0;
            else {
                int max = price[i-1];
                for (int j=i-1; j>=(i+1)/2; j--) {
                    if (dp[j] + dp[i-j] > max) {
                        max = dp[j] + dp[i-j];
                    }
                }
                dp[i] = max;
            }
        }
        return dp[n];
    }
}
