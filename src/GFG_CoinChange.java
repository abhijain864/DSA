public class GFG_CoinChange {

    public static void main(String[] args) {

    }

    public long count(int coins[], int N, int sum) {
        long[][] dp = new long[N+1][sum+1];
        for (int i=0;i<N+1;i++) {
            dp[i][0] = 1;
        }
        for (int j=1; j<sum+1 ;j++) {
            dp[0][j] = 0;
        }
        for (int i=1;i<N+1;i++) {
            for (int j=1; j<sum+1; j++) {
                if(j>= coins[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N+1][sum+1];
    }
}
