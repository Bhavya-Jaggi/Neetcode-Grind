class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer , Integer> hashMap = new HashMap<>();
        int max = 0,maxVal = 0;
        int[] res = new int[k];

        for(int x : nums)
        {
            if(hashMap.containsKey(x))
                hashMap.put(x , hashMap.get(x) + 1);
            
            else
                hashMap.put(x , 1);
        }

        int i = 0;
        while(i < k)
        {

            maxVal = 0;
            for(Map.Entry<Integer , Integer> entry : hashMap.entrySet())
            {

                int currVal = entry.getValue();
                int curr = entry.getKey();

                if(currVal > maxVal)
                {
                    maxVal = currVal;
                    max = curr;
                }
            }
            res[i++] = max;
            hashMap.put(max , 0);
        }
       return res;
    }
}