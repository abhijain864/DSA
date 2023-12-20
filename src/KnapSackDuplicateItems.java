public class KnapSackDuplicateItems {

    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[] dp = new int[W+1];
        dp[0] = 0;
        for (int w = 1; w <= W ; w++) {
            dp[w] = dp[w-1];
            for (int i = 0; i<N; i++) {
                if (wt[i] <= w) {
                    int possible = dp[w-wt[i]] + val[i];
                    if (possible > dp[w]) {
                        dp[w] = possible;
                    }
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        System.out.println(knapSack(4, 8, new int[]{6, 1, 7, 7}, new int[]{1, 3, 4, 5}));
    }

}
