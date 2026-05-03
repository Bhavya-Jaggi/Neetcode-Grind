class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        
        //Edge cases
        if(n == 1)
            return nums[0];
        if(n == 2)
            return Math.max(nums[0] , nums[1]);
            
        int[] dp = new int[n];//Street A runs from 1st to 2nd last house
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);

        int[] dpp = new int[n];//Street B runs from 2nd(leaving 1st house) to the last house
        //Base cases for Street B
        dpp[1] = nums[1];
        dpp[2] = Math.max(nums[1] , nums[2]);

        helpMe(2 , n - 1 , nums , dp);//We skip the last index in Street A
        helpMe(2 , n , nums , dpp);

        
        return Math.max(dp[n-2] , dpp[n-1]);//Since you skipped last index we check from 2nd last
        //cuz last is always 0
    }
    //Helper func for Basic house robber poblem
    public void helpMe(int start , int end , int[] arr, int[] dp)
    {
        for(int i = start ; i < end ; i++)
        {
            int choose = dp[i - 2] + arr[i];
            int notChoose = dp[i - 1];
            dp[i] = Math.max(choose , notChoose);
        }
    }
}