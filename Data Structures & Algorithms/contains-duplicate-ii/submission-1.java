class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int len = nums.length;

        Set<Integer> window = new HashSet<>();

        for(int i = 0 ; i < len ; i++)
        {
            if(window.size() == k + 1)
            {
                i--;
                window.remove(nums[i - k]);
            }
            else if(window.size() <= k + 1)
            {
                if(!window.add(nums[i]))
                    return true;
            }
            
        }
        return false;
    }
}