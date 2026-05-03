class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
            return nums[0];
        if(n == 1)
            return Math.max(nums[0] , nums[1]);


        //No need to initialize and pass both the "prev" just trust the DP
        int leaveLastHouse = helpMe(0 , n - 1 , nums);
        int leaveFirstHouse = helpMe(1 , n , nums);

        return Math.max(leaveFirstHouse , leaveLastHouse);

        
    }

    public int helpMe(int start , int end , int[] nums)
    {
        int prev1 = 0;
        int prev2 = 0;
        int sum = 0;
        for(int i = start ; i < end ; i++)
        {
            int choose = prev2 + nums[i];
            int notChoose = prev1;
            sum = Math.max(choose , notChoose);

            //Update the pointers(Very Imp I always forget this!)
            prev2 = prev1;
            prev1 = sum;
        }
        return sum;
    }
}