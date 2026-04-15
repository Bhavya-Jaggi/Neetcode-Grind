class Solution {
    public int longestConsecutive(int[] nums) {

        int max  = 1;

        if(nums.length == 0)
            return 0;
        
        Map<Integer , Integer> myMap = new HashMap<>();

        List<Integer> arrList = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            int curr = nums[i];

            if(!myMap.containsKey(curr))
            {
                arrList.add(curr);
                myMap.put(curr , 0);
            }
        }

        for(int i = 0 ; i < arrList.size() ; i++)
        {
            int curr = arrList.get(i);
            int currLen = 1, flag = 0;
            while(true)
            {
                if(myMap.containsKey(curr - 1) && flag == 0)
                    break;
                else if(myMap.containsKey(++curr))
                {
                    flag++;
                    currLen++;
                }
                else
                    break;
            }
            if(currLen > max)
                max = currLen;

        }

        return max;
    }
}