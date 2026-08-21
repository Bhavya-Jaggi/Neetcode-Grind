class Solution {
    public int maxArea(int[] height) {
        
        int left , right;

        left = 0;
        right = height.length - 1;
        int area = 0;

        while(left < right)
        {
            int currArea = Math.min(height[left] , height[right]) * (right - left);
            if(currArea > area)
                area = currArea;

            if(height[left] < height[right])
                left++;
            else if(height[left] > height[right])
                right--;
            else
            {
                left++;
                right--;
            }
        }

    return area;

    }
}