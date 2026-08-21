class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        int i , j , left , right;
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        if(len < 4)
            return res;

        for(i = 0 ; i <= len - 4 ; i++)
        {
            if(i > 0 && nums[i] == nums[i-1]) //Skip dupes for i
                continue;

            for(j = i + 1 ; j <= len - 3 ; j++)
            {
                if(j > i+1 && nums[j] == nums[j-1]) //Skip dupes for j (note j > i+1)
                    continue;
                
                left = j + 1;
                right = len - 1;
                while(left < right)
                {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target)
                    {
                        res.add(Arrays.asList( nums[i] , nums[j], nums[left] , nums[right] ));
                        left++;
                        right--;

                        while(left < right && nums[left] == nums[left-1])//Skipping left dupes
                            left++;

                        while(left < right && nums[right] == nums[right+1])//Skipping right dupes
                            right--;
                        
                    }
                    else if(sum > target)
                        right--;
                    else
                        left++;
                }
            }
        }
        
        return res;
    }
}