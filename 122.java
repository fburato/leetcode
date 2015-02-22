/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int firstEl = 0;
        int profit = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] < prices[i-1]) {
                profit = profit +  (prices[i-1] - prices[firstEl]);
                firstEl = i;
            }
        }
        profit = profit + prices[prices.length-1] - prices[firstEl];
        return profit;
    }
    /*
    class Triple {
        public int start;
        public int end;
        public int sum;
        public Triple(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
    
    public Triple maxProfit(int[] prices, int start, int end) {
        if(start == end) {
            return new Triple(start,end,0);
        }
        int min = prices[start], minIndex = start, maxIndex = start, profit = 0;
        for(int i = start+1; i <= end; ++i) {
            if(prices[i] - min > profit) {
                profit = prices[i] - min;
                maxIndex = i;
            }
            if(prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
        }
        return new Triple(minIndex,maxIndex,profit);
    }
    
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        Triple t = maxProfit(prices,0,prices.length-1);
        return maxProfit(prices,0,prices.length-1,t);
    }
    
    public int maxProfit(int[] prices, int start, int end, Triple current) {
        int profitLeft = 0, profitRight = 0;
        if(current.start > start) {
            Triple t = maxProfit(prices,start,current.start-1);
            profitLeft = maxProfit(prices,start,current.start-1,t);
        }
        if(current.end < end) {
            Triple t = maxProfit(prices,current.end+1,end);
            profitRight = maxProfit(prices,current.end+1,end,t);
        }
        return current.sum+profitLeft+profitRight;
    }
    */
}
