class Solution {
    public int subarraySum(int[] nums, int k) {

        int runningSum = 0;
        int res = 0;
        Map<Integer , Integer> freqMap = new HashMap<>();

        freqMap.put(0 , 1); //NEcessary step!

        for(int num : nums)
        {
            runningSum += num;

            if(freqMap.containsKey(runningSum - k)) //Since k = running - prev => prev = running - k.
                res += freqMap.get(runningSum - k);// if that prev is there in the map add it's frequency
            

            freqMap.put(runningSum , freqMap.getOrDefault(runningSum , 0) + 1); //Always put the running into map
            //Or increase it's freq by one if found already
            
        }
        return res;
    }
}