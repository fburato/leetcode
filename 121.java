/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
public class Solution {
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
        return maxProfit(prices,0,prices.length-1).sum;
    }
    /*public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] increments = new int[prices.length-1];
        for(int i = 1; i < prices.length; ++i) {
            increments[i-1] = prices[i] - prices[i-1];
        }
        return Math.max(0,maxProfit(increments,0,increments.length-1));
    }
    
    public int maxProfit(int[] inc, int start, int end) {
        if(start > end) {
            return Integer.MIN_VALUE;
        }
        if(start == end) {
            return inc[start];
        }
        int med = (start+end)/2;
        return Math.max(maxProfit(inc,start,med),Math.max(maxProfit(inc,med+1,end),maxCross(inc,start,med,end)));
    }
    
    public int maxCross(int[] inc, int start, int med, int end) {
        int maxLeft = inc[med], sum = maxLeft;
        for(int i = med-1; i >= start; --i) {
            sum += inc[i];
            if(sum > maxLeft) {
                maxLeft = sum;
            }
        }
        int maxRight = inc[med+1];
        sum = maxRight;
        for(int i = med+2; i <= end; ++i) {
            sum += inc[i];
            if(sum > maxRight) {
                maxRight = sum;
            }
        }
        return maxRight+maxLeft;
    }*/
}
