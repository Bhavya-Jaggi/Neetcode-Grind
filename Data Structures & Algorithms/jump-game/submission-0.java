class Solution {
    public boolean canJump(int[] nums) {
        
        int maxReach = 0;
        int currReach = 0;
        boolean t = false;

        for(int i = 0 ; i < nums.length ; i++)
        {
            currReach = i + nums[i];

            if(i > maxReach)
            {
                t = false;
                break;
            }
            if(currReach > maxReach)
                maxReach = currReach;

            if(maxReach >= nums.length - 1)
            {
                t = true;
                break;
            }
        }
        return t;

    }
}
