import java.util.Arrays;
import java.util.Stack;

public class GFG_NextGreaterElement {

    public static void main(String[] args) {
        nextLargerElement(new long[]{1L, 3L, 2L, 4L}, 4);
    }

    public static long[] nextLargerElement(long[] arr, int n)
    {
        long[] ans = new long[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            if (!stack.empty() && (arr[i] > arr[stack.peek()])) {
                while (!stack.isEmpty() && (arr[i] > arr[stack.peek()])) {
                    ans[stack.pop()] = arr[i];
                }
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans [stack.pop()] = -1;
        }
        return ans;
    }
}
