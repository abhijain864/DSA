import java.util.Arrays;

public class GFG_AggressiveCows {

    public static void main(String[] args) {
        System.out.println(solve(5, 3, new int[]{10, 1, 2, 7, 5}));

    }

    public static int solve3(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int maxAchievable = (stalls[n-1] - stalls[0])/(k-1);
        for (int sep = 1; sep <= maxAchievable; sep++) {
            if (!isAchievable(sep, k, stalls)) {
                return sep-1;
            }
        }
        return maxAchievable;
    }

    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int maxAchievable = (stalls[n-1] - stalls[0])/(k-1);
        int ans = 0;
        int l = 1, r = maxAchievable;
        while (l<=r) {
            int guess = (l+r)/2;
            if(isAchievable(guess,k, stalls)) {
                ans = guess;
                l = guess + 1;
            } else {
                r = guess - 1;
            }
        }
        return ans;
    }

    private static boolean isAchievable(int guess, int k, int[] stalls) {
        int countOfCows = 1;
        int curr = stalls[0];
        for (int i=1; i< stalls.length; i++) {
            if (countOfCows == k) {
                return true;
            }
            if (stalls[i] - curr >= guess) {
                countOfCows++;
                curr = stalls[i];
            }
        }
        return countOfCows == k;
    }
}
