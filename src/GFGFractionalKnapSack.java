import java.util.Arrays;
import java.util.Comparator;

public class GFGFractionalKnapSack {

    static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n)
    {
        double ans = 0;
        int i=0;
        Arrays.sort(arr, Comparator.comparingDouble(item -> (double) item.weight / (double) item.value));
        while (i<n && W>0) {
           if (arr[i].weight < W) {
               ans += arr[i].value;
               W-=arr[i].weight;
               i++;
           } else {
               ans += W * ((double) arr[i].value)/(arr[i].weight);
               break;
           }
        }
        return ans;
    }

    public static void main(String[] args) {
        new GFGFractionalKnapSack().fractionalKnapsack(50, new Item[] {new Item(60,10), new Item(100,20), new Item(120,30)}, 3);
    }
}
