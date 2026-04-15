class Solution {
    public int majorityElement(int[] nums) {

        Map<Integer , Integer> freqMap = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            int curr = nums[i];
            if(freqMap.containsKey(curr))
                freqMap.put(curr , freqMap.get(curr) + 1);
            else
                freqMap.put(curr , 1);
        }

        int max = -1;
        int element = 0;

        for(Map.Entry<Integer , Integer> entry : freqMap.entrySet())
        {
            if(entry.getValue() > max)
            {
                max = entry.getValue();
                element = entry.getKey();
            }
        }
        return element;
        
    }
}