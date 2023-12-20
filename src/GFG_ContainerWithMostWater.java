public class GFG_ContainerWithMostWater {

    public static void main(String[] args) {

    }

    long maxArea(int A[], int len){
        long ans = 0;
        int l = 0, r = len - 1;
        while(l<r) {
            if (A[l] > A[r]) {
                long i = (long) (r - l) * A[r];
                if (i>ans) {
                    ans = i;
                }
                r--;
            } else {
                long i = (long) (r - l) * A[l];
                if (i>ans) {
                    ans = i;
                }
                l++;
            }
        }
        return ans;
    }
}
