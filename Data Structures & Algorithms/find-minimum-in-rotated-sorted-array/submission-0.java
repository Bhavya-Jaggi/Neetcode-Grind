class Solution {
    public int findMin(int[] nums) {
        
        int len = nums.length;
        if(len == 1)
            return nums[0];
        else if(len == 2)
            return Math.min(nums[0] , nums[1]);

        int left = 0,right = len -1,mid,ans = 0;

        while(left <= right)
        {
            mid = (left + right) / 2;
            
            if(nums[mid] > nums[mid + 1])
            {
                ans = nums[mid+1];
                break;
            }
            else if(nums[mid] < nums[mid - 1])
            {
                ans = nums[mid];
                break;
            }
            else if(nums[right] < nums[mid])
                left = mid + 1;
            else if(nums[left] > nums[mid])
                right = mid - 1;
            else if(nums[left] < nums[right])
            {
                ans = nums[0];
                break;
            }
            
        }
        return ans;
    }
}