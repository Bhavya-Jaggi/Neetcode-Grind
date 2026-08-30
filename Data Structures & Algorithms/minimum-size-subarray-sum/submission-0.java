class Solution {
    public int minSubArrayLen(int target, int[] nums) {


        int left = 0;
        int right = 0;
        int len = nums.length;
        int minLengthSoFar = len + 1;
        int currSum = 0;
        int flag = 0;

        while(right < len)
        {
            int curr = nums[right];
            currSum += curr;
            

            while(currSum >= target)
            {
                minLengthSoFar = Math.min(minLengthSoFar , (right - left + 1));
                currSum -= nums[left];
                left++;
                flag = 1;
            }
            
            right++;
            
        }
        if(flag == 1)
            return minLengthSoFar;
        else
            return 0;
        
    }
}