class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int buyDay=0;
        int sellDay=buyDay+1;

        while(sellDay <prices.length) {
            if(prices[buyDay]<prices[sellDay]) {
                maxProfit = Math.max(maxProfit, prices[sellDay]-prices[buyDay]);
                sellDay++;
            } else if(prices[buyDay]>prices[sellDay]) {
                buyDay=sellDay;
                sellDay++;
            } else {
                sellDay++;
            }
        }
        return maxProfit<0?0:maxProfit;
    }
}
