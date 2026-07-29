    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            
            int max = -1;
            int ans = 0;
            for(int x : piles)
            {
                if(max < x)
                    max = x;
            }
            int low = 1;

            while(low <= max)
            {
                int mid = low + ((max - low)/2);
                // int mid = (low + max)/2;
                long sum = 0;

                for(int x : piles)
                {
                    sum += Math.ceil((double)x/mid);
                }

                if(sum <= h)
                {
                    ans = mid;
                    max = mid - 1;
                }

                else
                    low = mid + 1;
            }


        return ans;
        }
    }