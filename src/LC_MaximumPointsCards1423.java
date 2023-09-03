
public class LC_MaximumPointsCards1423 {
    public static void main(String[] args) {
        int[] cardPoints = new int[]{1,2,3,4,5,6,1};
        System.out.println(new LC_MaximumPointsCards1423().maxScore(cardPoints, 3));
    }

    public int maxScore(int[] cardPoints, int k) {
        int minSum=0, totSum=0;
        k = cardPoints.length - k;
        for(int i=0;i<cardPoints.length;i++){
            if (i<k) {
                minSum+=cardPoints[i];
            }
            totSum+=cardPoints[i];
        }
        int currSum = minSum;
        for(int i=1; i<=cardPoints.length - k; i++) {
            currSum = currSum - cardPoints[i-1] + cardPoints[k-1+i];
            if(currSum < minSum){
                minSum = currSum;
            }
        }
        return totSum-minSum;
    }


}
