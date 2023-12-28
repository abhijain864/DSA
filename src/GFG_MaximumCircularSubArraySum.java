public class GFG_MaximumCircularSubArraySum {

    public static void main(String[] args) {
        System.out.println(circularSubarraySum(new int[]{8, -8, 9, -9, 10, -11, 12}, 7));
    }

    static int circularSubarraySum(int a[], int n) {
        if (n==1) return a[0];
        int maxSum = a[0], currMaxSum = a[0], minSum = a[0], currMinSum = a[0], cumSum = a[0];
        for (int i=1; i<n; i++) {
            cumSum+=a[i];
            if (currMaxSum > 0) {
                currMaxSum+=a[i];
            } else {
                currMaxSum = a[i];
            }
            if (currMinSum < 0) {
                currMinSum+=a[i];
            } else {
                currMinSum = a[i];
            }
            if (currMaxSum > maxSum) {
                maxSum = currMaxSum;
            }
            if (currMinSum < minSum) {
                minSum = currMinSum;
            }
        }
        return maxSum < 0 ? maxSum : Math.max(maxSum, cumSum - minSum);
    }
}
