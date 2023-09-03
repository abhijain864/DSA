import java.util.Arrays;
import java.util.Comparator;

class Pair
{
    int x;
    int y;

    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }

}

public class GFG_MaxLengthChain {

    public static void main(String[] args) {

    }

    int maxChainLength(Pair arr[], int n)
    {
        Arrays.sort(arr, Comparator.comparingInt(p -> p.y));
        int count = 1;
        int occupiedTill = arr[0].y;
        for (int i=1; i<arr.length; i++) {
            if(arr[i].x < occupiedTill){
                i++;
            } else {
                count+=1;
                occupiedTill = arr[i].y;
            }
        }
        return count;
    }
}
