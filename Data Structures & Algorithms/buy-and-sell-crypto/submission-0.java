class Solution {
    public int maxProfit(int[] nums) {
        int left = 0,right = 1;
        int buy,sell,maxProfit  = 0;

        if(nums.length == 1)
            return 0;

        while(right < nums.length)
        {
            if(nums[left] > nums[right])
            {
                left = right;
                right = left + 1;
            }
            else
            {
                int profit = nums[right] - nums[left];
                if(profit > maxProfit)
                {
                    buy = left;
                    sell = right;
                    maxProfit = profit;
                }
                right++;
            }
            
        }
        return maxProfit;

    }
}