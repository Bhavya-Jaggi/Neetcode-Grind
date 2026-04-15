class Solution {
    public List<Integer> majorityElement(int[] nums) {

        Map<Integer , Integer> freqMap = new HashMap<>();

        int req = nums.length / 3;

        List<Integer> arrList = new ArrayList<>();

        for(int num : nums)
        {
            if(freqMap.containsKey(num))
                freqMap.put(num , freqMap.get(num) + 1);
            else
                freqMap.put(num , 1);
        }

        for(Map.Entry<Integer , Integer> entry : freqMap.entrySet())
        {
            if(entry.getValue() > req)
                arrList.add(entry.getKey());
        }

        return arrList;
        
    }
}