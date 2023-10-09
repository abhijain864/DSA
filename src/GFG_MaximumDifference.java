import java.util.Stack;

public class GFG_MaximumDifference {

    public static void main(String[] args) {
        // 5, 3, 23, 45, 12, 32, 17, 23, 9, 16, 26 |0
        // nearest smaller element to the left, and right
        //
        //
        new GFG_MaximumDifference().findMaxDiff(new int[]{5, 3, 23, 45, 12, 32, 17, 23, 9, 16, 26}, 11);
        //
        //
        //
    }

    void findMaxDiff(int a[], int n)
    {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();
        int[] ls = new int[n];
        int[] rs = new int[n];
        s1.push(0);
        for (int i = n-1; i>=0; i--) {
            while(a[i] <= s1.peek()) {
                s1.pop();
            }
            rs[i] = s1.peek();
            s1.push(a[i]);
        }

        s2.push(0);
        for (int i = 0; i<n; i++) {
            while(a[i] <= s2.peek()) {
                s2.pop();
            }
            rs[i] = s2.peek();
            s2.push(a[i]);
        }

    }



}
