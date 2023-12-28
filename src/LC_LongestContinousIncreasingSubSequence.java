public class LC_LongestContinousIncreasingSubSequence {

    public static void main(String[] args) {
        System.out.println(new LC_LongestContinousIncreasingSubSequence().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    }

    public int findLengthOfLCIS(int[] nums) {
        int max = 1, currMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                currMax++;
            } else {
                currMax = 1;
            }
            if (currMax > max) {
                max = currMax;
            }
        }
        return max;
    }
}
