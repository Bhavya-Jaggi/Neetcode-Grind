class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Arrays.sort(piles);
        int len = piles.length;
        int left = 1,right = (int)Math.pow(10,9),mid = 0;
        long k = 0;
        // Deque<Integer> stack = new ArrayDeque<>();
        int ans = right;



        while(left <= right)
        {
            mid = left + (right - left) / 2;
            k = 0;
            for(int i = 0; i < len ; i++)
            {
                int curr = 0;
                int r = piles[i] % mid;
                if(r == 0)
                    curr = piles[i] / mid;
                else
                    curr = (piles[i] / mid) + 1;
                k += curr;
            }
            if(k > h)
            {
                left = mid + 1;
            }
            else if(k <= h)
            {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }
}