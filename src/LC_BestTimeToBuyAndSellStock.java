public class LC_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minTillNow = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minTillNow) {
                minTillNow = price;
            }
            if (price - minTillNow > maxProfit) {
                maxProfit = price - minTillNow;
            }
        }
        return maxProfit;
    }
}
