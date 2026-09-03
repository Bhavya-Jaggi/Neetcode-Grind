class Solution {
    public int search(int[] nums, int target) {

        int res = -1;

        int left = 0;
        int right = nums.length - 1;

        while(left <= right)
        {
            int mid = left + right; 
            mid /= 2;

            if(nums[mid] == target)
            {
                res = mid;
                break;
            }
            else if(nums[mid] > nums[left] && target < nums[mid] && target >= nums[left])
            {
                right = mid -1;
            }
            else if(nums[mid] < nums[left] && target > nums[mid] && target >= nums[left])
            {
                right = mid - 1;
            }
            else if(nums[mid] < nums[left] && target < nums[mid] && target <= nums[left])
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return res;
    }
}