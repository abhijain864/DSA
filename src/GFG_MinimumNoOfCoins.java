import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GFG_MinimumNoOfCoins {

    public static void main(String[] args) {

    }

     static List<Integer> minPartition(int N)
    {
        List<Integer> coins = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 2000);
        int i = coins.size() - 1;
        List<Integer> ans = new ArrayList<>();
        while (i>=0 && N != 0) {
            if (coins.get(i) > N) {
                i--;
            } else {
                N-=coins.get(i);
                ans.add(coins.get(i));
            }
        }
        return ans;
    }
}
