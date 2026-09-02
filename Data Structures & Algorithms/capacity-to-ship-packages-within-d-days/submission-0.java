class Solution {
    public int shipWithinDays(int[] w, int d) {
        
        int sum = 0;
        int maxWeight = 0;
        int ans = -1;
        for(int i : w)
        {
            maxWeight = Math.max(i , maxWeight);
            sum += i;
        }

        int min = maxWeight;
        int max = sum;

        while(min <= max)
        {
            int mid = min + max;
            mid /= 2;
            int days = 1;
            int currSum = 0;

            for(int i = 0 ; i < w.length ; i++)
            {
                currSum += w[i];
                if(currSum > mid)
                {
                    days++;
                    currSum = 0;
                    i--;
                }
            }
            if(days <= d)
            {
                ans = mid;
                max = mid - 1;
            }
            else
                min = mid + 1;
        }
    return ans;
    }
}