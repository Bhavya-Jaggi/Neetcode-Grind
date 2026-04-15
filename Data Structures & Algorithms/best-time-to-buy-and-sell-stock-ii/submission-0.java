class Solution {
    public int maxProfit(int[] prices) {

        int profit = 0;
        int len = prices.length;

        for(int i = 1 ; i < len ; i++)
        {
            int diff = prices[i] - prices[i-1];
            if(diff <= 0)
                continue;
            else
                profit += diff;
        }
        return profit;
    }
}