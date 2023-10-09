import java.util.HashMap;

public class GFG_LongestArithmeticProgression {

    public static void main(String[] args) {
        new GFG_LongestArithmeticProgression().lengthOfLongestAP(new int[]{1, 7, 10, 13, 14, 19}, 6);
    }

    int lengthOfLongestAP(int[] A, int n) {
        int ans = 1;
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i=0;i <n; i++) {
            numMap.put(A[i], i);
        }
        int dp[][] = new int[n][n];
        for (int i=n-1; i>=0; i--) {
            for (int j=n-1; j>i; j--) {
                if (j == n-1) {
                    dp[i][j] = 2;
                }
                else if(numMap.containsKey(A[j] + A[j] - A[i])){
                    dp[i][j] = dp[j][numMap.get(A[j] + A[j] - A[i] )] + 1;
                } else {
                    dp[i][j] = 2;
                }

                if (dp[i][j] > ans) {
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }


}
