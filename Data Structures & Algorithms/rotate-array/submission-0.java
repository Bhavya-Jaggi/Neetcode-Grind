class Solution {
    public void rotate(int[] nums, int k) {

        int len = nums.length;

        int[] res = new int[len];
        
        int c = 0;

        if(k > len) //This is necessary cuz if k > len we normalise k
            k = k % len;

        

        for(int i = len-k ; c < k ; i++ , c++)
        {
            res[c] = nums[i];
        }
        int i = 0;
        while(c < len)
        {
            res[c++] = nums[i++];
        }

        i = 0;

        while(i < len)
        {
            nums[i] = res[i];
            i++;
        }
        
    }
}