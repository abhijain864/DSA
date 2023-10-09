import java.util.Arrays;

public class GFG_3SumClosest {

    public static void main(String[] args) {
        System.out.println(closest3Sum(new int[]{-1,2,1,-4}, 4, 1));
    }

    static int closest3Sum(int A[], int N, int X)
    {
        int minDiff = Math.abs(X-(A[0]+A[1] +A[2]));
        int ans = A[0] + A[1] + A[2];
        Arrays.sort(A);
        for (int k=0;k <N; k++) {
            int i = k+1, j = N-1;
            while (i<j) {
                if (Math.abs(X-(A[k] + A[i] + A[j])) < minDiff) {
                    minDiff = Math.abs(X-(A[k] + A[i] + A[j]));
                    ans = A[k] + A[i] + A[j];
                }
                if(A[k] + A[i] + A[j] <  X) {
                    i++;
                } else if (A[k] + A[i] + A[j] > X) {
                    j--;
                } else {
                    return X;
                }
            }
        }
        return ans;
    }
}
