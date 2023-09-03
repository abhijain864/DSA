import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GFG_LongestIncreasingSubsequence {

    public static void main(String[] args) {

    }

    static int longestSubsequence(int size, int a[])
    {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(size,1));
        new ArrayList<>(Collections.singleton(a));
        int ans = 1;
        for (int i=1; i<size; i++) {
            for (int j=0; j<i; j++) {
                if (a[j]<a[i]) {
                    dp.set(i, Math.max(dp.get(i),dp.get(j)+1));
                }
            }
            ans = Math.max(ans, dp.get(i));
        }
        return ans;
    }
}
