class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        int n = nums.length;

        if(n <= 2)
            return nums[0];

        do
        {
            

            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast)
                break;

        } while(true);

        slow = 0;

        do
        {
            if(slow == fast)
                return slow;
            
            slow = nums[slow];
            fast = nums[fast];
        } while(true);
    }
}