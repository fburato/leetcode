/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int firstEl = 0;
        int profit = 0;
        int twoBest = new int[2];
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] < prices[i-1]) {
                profit = profit +  (prices[i-1] - prices[firstEl]);
                firstEl = i;
            }
        }
        profit = profit + prices[prices.length-1] - prices[firstEl];
        return profit;
    }
    
    public void processNewBest(int best[], int profit) {
        if(profit > best[1]) {
            best[0] = best[1];
            best[1] = profit;
        }
        if(profit > best[0]) {
            best[0] = profit; 
        }
    }
}
