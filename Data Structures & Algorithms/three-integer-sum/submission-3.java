class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int left , right;

        for(int i = 0 ; i < nums.length - 2 ; i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int pivot = nums[i];
            left = i + 1;
            right = nums.length - 1;


            while(left < right)
            {
                int calc = nums[left] + nums[right] + pivot;
                if(calc == 0)
                {
                    res.add(Arrays.asList( nums[left] , nums[right] , pivot  ) );
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1])
                        left++;
                }
                else if(calc < 0)
                    left++;
                else
                    right--;

                    
                    

            }
        }
    return res;
    }
}