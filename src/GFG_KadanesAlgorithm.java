import java.util.Arrays;

public class GFG_KadanesAlgorithm {

    public static void main(String[] args) {

    }

    long maxSubarraySum(int arr[], int n){
        // The sub-question to ask is for each sub-array,
        long maxSubSum=arr[0];
        long maxSubSumEndingAtI=0;
        for (int j : arr) {
            if (maxSubSumEndingAtI <= 0) {
                maxSubSumEndingAtI = j;
            } else {
                maxSubSumEndingAtI += j;
            }
            if (maxSubSumEndingAtI > maxSubSum) {
                maxSubSum = maxSubSumEndingAtI;
            }
        }
        return maxSubSum;
    }

    static int smallestSumSubarray(int a[], int size)
    {
        int minSubSum=a[0];
        int minSubSumEndingAtI=0;
        for (int j : a) {
            if (minSubSumEndingAtI >= 0) {
                minSubSumEndingAtI = j;
            } else {
                minSubSumEndingAtI += j;
            }
            if (minSubSumEndingAtI < minSubSum) {
                minSubSum = minSubSumEndingAtI;
            }
        }
        return minSubSum;
    }
}
