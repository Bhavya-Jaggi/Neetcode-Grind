class Solution {
    public int searchInsert(int[] nums, int x) {
        
        int left = 0;
        int len = nums.length;
        int right = len - 1;

        while(left <= right)
        {
            int mid = left + right;
            mid /= 2;

            if(x == nums[mid])
                return mid;
            
            else if(x > nums[mid])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

    return left;
    }
}