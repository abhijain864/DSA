public class GFG_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] ar1 = new int[]{3,7,9,14,14,17,20,25,26,31,35,35,36,38,42,42};
        int[] ar2 = new int[]{4,6,6,8,13,17,18,21,22,22,27,29,34,36,39,41};
        new GFG_MedianOfTwoSortedArrays().findMidSum(ar1,ar2,ar1.length);
    }

    int findMidSum(int[] ar1, int[] ar2, int n) {
        if (ar1[n-1]<=ar2[0]) {
            return ar1[n-1] + ar2[0];
        } else if (ar2[n-1]<=ar1[0]) {
            return ar2[n-1] + ar1[0];
        } else {
            int l = 1, r = n-1;
            int p1 = (l+r)/2;
            // Find
            while(l < r) {
                p1 = (l+r)/2;
                if (ar1[p1-1] > ar2[n-p1]) {
                    r = p1 - 1;
                } else if (ar2[n-p1-1] > ar1[p1]) {
                    l = p1 + 1;
                } else {
                    break;
                }
            }
            int withinBorMax = Math.max(ar1[p1-1], ar2[n-p1-1]);
            int outsideBorMin = Math.min(ar1[p1], ar2[n-p1]);
            return withinBorMax + outsideBorMin;
        }
    }
}
