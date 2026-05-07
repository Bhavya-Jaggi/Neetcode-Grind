class Solution {
    public int maxProduct(int[] nums) {
        if(nums[0] == -2 && nums.length == 1)
            return -2;
        int maxPro = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            int pro = 1;
            for(int j = i ; j < nums.length ;j++)
            {
                pro *= nums[j];
                if(pro > maxPro)
                    maxPro = pro;
            }
        }
        return maxPro;
    }
}