class Solution {
    public int[] getConcatenation(int[] nums) {

        int len = nums.length;
        int flag = 0;
        int[] res = new int[2*len];


        for(int i = 0 ; i < nums.length ; i++)
        {
            res[i] = nums[i];
        }
        for(int i = 0 ; i < len ; i++)
        {
            res[i + len] = nums[i];
        }
        return res;
    }
}