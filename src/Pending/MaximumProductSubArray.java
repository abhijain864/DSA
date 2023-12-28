package Pending;

public class MaximumProductSubArray {

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubArray().maxProduct(new int[]{-2, 0, 1}));
    }

    public int maxProduct(int[] nums) {
        int maxProd = nums[0], currMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] >=0 && currMax >=0) || (nums[i]<=0 && currMax <=0)) {
                currMax = currMax * nums[i];
            } else {
                currMax = nums[i];
            }

            if (currMax > maxProd) {
                maxProd = currMax;
            }
        }
        return maxProd;
    }
}
