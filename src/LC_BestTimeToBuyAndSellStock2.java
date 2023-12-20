public class LC_BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        // buy represents what i need to do next
        boolean buy = true;
        int buyPrice = 0;
        int maxProfit = 0;
        for (int i = 0; i<prices.length-1; i++) {
            if (buy) {
                if (prices[i+1]-prices[i] > 0) {
                    buy = false;
                    buyPrice = prices[i];
                }
            } else {
                if (prices[i+1]-prices[i] < 0) {
                    maxProfit += prices[i] - buyPrice;
                    buy = true;
                }
            }
        }
        if (!buy) {
            maxProfit += prices[prices.length-1] - buyPrice;
        }
        return maxProfit;
    }

    /* Same solution with more short and precise code */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for (int i=0; i<prices.length-1; i++) {
            if (prices[i+1]-prices[i] > 0) {
                maxProfit += prices[i+1]-prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(new LC_BestTimeToBuyAndSellStock2().maxProfit(new int[]{7,6,4,3,1}));
    }

}
