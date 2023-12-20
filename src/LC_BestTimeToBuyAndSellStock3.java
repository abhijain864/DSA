import java.util.Arrays;

/* We will discuss 3 solutions to this problem */
public class LC_BestTimeToBuyAndSellStock3 {

    /* solution number 1 -> divide and conquer approach */
    /* ------------*/
    public int maxProfit(int[] prices) {
        int ans = 0;
        int leftMin = prices[0], rightMax = prices[prices.length-1];
        // leftDp[i] -> stores max trade you can perform if you sell on or before day i
        int[] leftDp = new int[prices.length];
        // rightDp[i] -> stores max trade you can perform if you buy on or after day i
        int[] rightDp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < leftMin) {
                leftMin = prices[i];
            }
            leftDp[i] = Math.max(prices[i] - leftMin, leftDp[i - 1]);
        }
        for (int i = prices.length-2; i >= 0; i--) {
            if (prices[i] > rightMax) {
                rightMax = prices[i];
            }
            rightDp[i] = Math.max(rightMax-prices[i], rightDp[i+1]);
        }
        for (int i=0; i<prices.length; i++) {
            if (leftDp[i] + rightDp[i] > ans) {
                ans = leftDp[i] + rightDp[i];
            }
        }
        return ans;
    }


    /* solution no 2 -> simple plain recursion */
    /*--------------*/
    private int ans = 0;

    public int maxProfit2(int[] prices) {
        recurse(0, true, 2, prices.length, 0, prices);
        return ans;
    }

    public void recurse(int idx, boolean buy, int transactions, int n, int profit, int[] prices) {
        if (idx==n) {
            if (transactions == 0 || transactions == 1) {
                if (profit > ans) {
                    ans = profit;
                }
            }
            return;
        }
        if (buy) {
            // buy
            recurse(idx+1, false, transactions, n, profit-prices[idx], prices);
            // skip
            recurse(idx+1, true, transactions, n, profit, prices);
        } else {
            // sell
            recurse(idx+1, true, transactions-1, n, profit+prices[idx], prices);
            // skip
            recurse(idx+1, false, transactions, n, profit, prices);
        }
    }

    /* solution no 3 -> recursion with memoization */
    /*--------------*/

    public int maxProfit3(int[] prices) {
        int[][][] dp = new int[2][3][prices.length+1];
        for (int i=0;i<=1;i++) {
            for (int j=0;j<=2;j++) {
                for (int k=0;k<=prices.length;k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return recurse2(0, 1, 2, prices.length,  prices, dp);
    }

    public int recurse2(int idx, int buy, int transactions, int n, int[] prices, int[][][] dp) {
        if (idx==n || transactions<=0) {
            return 0;
        }
        if (dp[buy][transactions][idx] != -1) {
            return dp[buy][transactions][idx];
        }
        if (buy == 1) {
            // buy
            int buyAns = recurse2(idx+1, 0, transactions, n,  prices, dp);
            // skip
            int skipAns = recurse2(idx+1, 1, transactions, n,  prices, dp);
            dp[buy][transactions][idx] = Math.max(-prices[idx] + buyAns, skipAns);
            return dp[buy][transactions][idx];
        } else {
            // sell
            int sellAns = recurse2(idx+1, 1, transactions-1, n,  prices, dp);
            // skip
            int skipAns = recurse2(idx+1, 0, transactions, n,  prices, dp);
            dp[buy][transactions][idx] = Math.max(prices[idx] + sellAns, skipAns);
            return dp[buy][transactions][idx];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,4,2,5,7,2,4,9,0};
        System.out.println(new LC_BestTimeToBuyAndSellStock3().maxProfit3(new int[]{1,2,4,2,5,7,2,4,9,0}));
    }

}
