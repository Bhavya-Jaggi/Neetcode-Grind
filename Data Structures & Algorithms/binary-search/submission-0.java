class Solution {
    public int search(int[] nums, int target) {
        int med,first,last;
        int len = nums.length;
        first = 0;
        last = len - 1;

        while(first <= last)
        {
            med = (first + last)/2;

            if(nums[med] == target)
                return med;

            else if(nums[med] < target)
                first = med + 1;

            else if(nums[med] > target)
                last = med - 1;
        }
        return -1;
    }
}