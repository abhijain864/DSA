public class GFG_FormAPalindrome {

    public static void main(String[] args) {

    }

    static int countMin(String str)
    {

        int a = lcs(str.length(), str.length(), str, new StringBuilder(str).reverse().toString());
        return str.length()-a;
    }

    static int lcs(int x, int y, String s1, String s2)
    {
        int dp[][] = new int[x+1][y+1];
        for (int i=0; i<x+1; i++){
            dp[i][0] = 0;
        }
        for (int j=0; j<y+1; j++){
            dp[0][j] = 0;
        }

        for (int i=1;i<x+1;i++) {
            for (int j=1; j<y+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1 ;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }
}
