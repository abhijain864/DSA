public class GFG_KnapSack01 {

    public static void main(String[] args) {

    }

    static int knapSack(int W, int wt[], int val[], int n)
    {
        int arr[][] = new int[n+1][W+1];
        for (int i=0; i<wt.length+1; i++) {
            arr[i][0] = 0;
        }
        for (int j=0; j<wt.length+1; j++) {
            arr[0][j] = 0;
        }
        for( int i=1; i< wt.length+1; i++) {
            for( int j=1; j< wt.length+1; j++) {
                if (wt[i-1] > j) {
                    arr[i][j] = arr[i-1][j];
                } else {
                    arr[i][j] = Math.max(val[i-1] + arr[i-1][j-wt[i-1]], arr[i-1][j]);
                }
            }
        }
        return arr[n][W];
    }

    public int minOperation(int n)
    {
        int arr[] = new int[n+1];
        arr[1] = 1;
        for(int i=2;i<=n;i++) {
            if(i%2!=0) {
                arr[i] = arr[i-1];
            } else {
                arr[i] = Math.min(arr[i/2],arr[i-1]);
            }
        }
        return arr[n];
    }
}
