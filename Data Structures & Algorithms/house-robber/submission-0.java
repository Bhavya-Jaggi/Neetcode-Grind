// Did it myself!
class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0] , nums[1]);
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // dp[1] = nums[1]; This is wrong cuz this believes that u chose house 1 mandatorily
        dp[1] = Math.max(nums[0] , nums[1]);//This is right cuz if nums[0] >>> nums[1] then we chose
        //nums[0] now if we chose nums[0] we cannot add the nums[1] to it cuz they are ajdescent

        for(int i = 2 ; i < nums.length ; i++)
        {
            int choose = nums[i] + dp[i - 2];//If choose this leave the adjescent
            int notChoose = dp[i - 1];//If NotChoose this chose the adjescent value

            dp[i] = Math.max(choose , notChoose);
        }
        return dp[dp.length - 1];//The last element of the array is our final loot yayy
    }
}