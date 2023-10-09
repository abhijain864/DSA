import java.util.Arrays;

public class GFG_MinTheHeights1 {

    public static void main(String[] args) {

    }

    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);
        int ans = arr[n-1]-arr[0];
        for (int i=1; i<=n-1;i++) {
            if (arr[i] >= k){
                int max = Math.max(arr[i-1] + k, arr[n-1] - k);
                int min = Math.min(arr[i] - k, arr[0] + k);
                ans = Math.min(ans, max - min);
            }
        }
        return ans;
    }
}
