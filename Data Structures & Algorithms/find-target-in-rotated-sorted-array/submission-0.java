class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;

        if(len == 1)
        {
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }
        else if(len == 2)
        {
            if(nums[0] == target)
                return 0;
            else if(nums[1] == target)
                return 1;
            else 
                return -1;
        }

        int left = 0 , right = len - 1,mid , ans = -1,pivot = 0;

        while(left <= right)
        {
            mid = (left + right) / 2;

            if(nums[mid] > nums[mid+1])
            {
                pivot = mid + 1;
                break;
            }
            else if(nums[mid] < nums[mid - 1])
            {
                pivot = mid;
                break;
            }

            else if(nums[mid] > nums[right])
                left = mid + 1;
            else if(nums[mid] < nums[left])
                right = mid - 1;

            else if(nums[left] < nums[right])
            {
                pivot = 0;
                break;
            }
        }
        
            left = 0;
            right = len - 1;

            if(target >= nums[pivot] && target <= nums[right])
                left = pivot;
            else
                right = pivot -1;
            while(left <= right)
            {
                mid = (left + right) /2;
                if(target == nums[mid])
                {
                    ans = mid;
                    break;
                }
                else if(target > nums[mid])
                {
                    left = mid + 1;
                }
                else if(target < nums[mid])
                    right = mid - 1;
            }
        
        return ans;

    }
}