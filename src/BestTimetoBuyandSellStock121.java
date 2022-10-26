/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">
 * 121. Best Time to Buy and Sell Stock</a>
 */
public class BestTimetoBuyandSellStock121 {

    public static void main(String[] args) {

        //int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {7, 6, 4, 3, 1};

        System.out.println(maxProfit(prices));

    }

    private static int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int l = 0;
        int r = 1;
        int maxProfit = 0;

        while (r < prices.length) {

            if (prices[l] < prices[r]) {
                maxProfit = Math.max(maxProfit, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}
