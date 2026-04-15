class Solution {
    public int maxArea(int[] height) {
        
        int left,right;
        int n = height.length;
        int i = 0,j = n -1;
        int min = 0 , maxPro = 0;

        while(i < j)
        {
            left = height[i];
            right = height[j];
            min = Math.min(left , right);

            int curr = min * (j - i) ;
            if(curr > maxPro)
            {
                maxPro = curr;
            }
            if(left == min)
            {
                i++;
            }
            else if(right == min)
            {
                j--;
            }
            
        }
        
        return maxPro;

    }
}