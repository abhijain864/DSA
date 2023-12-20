import java.util.Arrays;

public class LCMaximumSumOf3NonOverlappingSubarrays {

    /* The below soln needs to be modified a little. it will give the sum, and not the actual indices of the elements*/
    public int maxSumOfThreeSubarrays(int[] nums, int k) {
        int maxThreeSubArraysSum = 0;
        int[] twoSumSubarray = new int[nums.length];
        int length = nums.length;
        int[] frontDp = new int[length];
        frontDp[k-1] = sumIdx(0, k-1, nums);
        int[] backDp = new int[length];
        backDp[length-k] = sumIdx(length-k, length-1, nums);
        // in frontDp we will store the sum of elements of the (sub array of length k) which ends on or before index i and has the maximum sum
        for (int i=k; i<length; i++) {
            frontDp[i] = Math.max(frontDp[i-1], sumIdx(i, i+k-1, nums));
        }
        // in backDp we will store the sum of elements of the (sub array of length k) which starts on or before index i and has the maximum sum
        for (int i = length - k - 1; i >= 0; i--) {
            backDp[i] = Math.max(backDp[i+1], sumIdx(i, i+k-1, nums));
        }
        for (int i=k-1; i<length-k; i++) {
            twoSumSubarray[i+k] = Math.max(twoSumSubarray[i+k-1], frontDp[i] + backDp[i+1]);
        }
        for (int i= 2*k-1; i<length-k; i++) {
            int sum = twoSumSubarray[i] + backDp[i + 1];
            if (sum > maxThreeSubArraysSum) {
                maxThreeSubArraysSum = sum;
            }
        }
        return maxThreeSubArraysSum;
    }

    private int sumIdx (int start, int end, int[] arr) {
        int sum = 0;
        for (int i = start; i<=end; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    /* Dynamic programming solution */
    public int[] maxSumOfThreeSubarraysDp(int[] nums, int k) {
        int[][] dp = new int[k+1][nums.length+1];
        int[] ans = new int[3];
        System.out.println(recurse(0, 3, nums, ans, k));
        return ans;
    }

    private int recurse(int idx, int noOfSubArr, int[] nums, int[] ans, int k) {
        if (idx > nums.length - k || noOfSubArr<=0 ){
            return 0;
        }
        // 1. pick
        int pick = sumIdx(idx, idx+k-1, nums) + recurse(idx+k, noOfSubArr-1, nums, ans, k);
        // 2. skip
        int skip = recurse(idx+1, noOfSubArr, nums, ans, k);
        if (pick >= skip) {
            ans[3-noOfSubArr] = idx;
            return pick;
        } else {
            return skip;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LCMaximumSumOf3NonOverlappingSubarrays().maxSumOfThreeSubarraysDp(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
    }

}
