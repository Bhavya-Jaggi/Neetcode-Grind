class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> myMap = new HashMap<>();
    //    List<ArrayList> list = new ArrayList<>()
    int[] arr = {};
       for(int i=0;i<nums.length;i++)
       {
            if(myMap.containsKey(nums[i]))
            {
                if(2*nums[i] == target)
                    return new int[]{myMap.get(nums[i]), i};
            }
            else
                myMap.put(nums[i] , i);
       }
       for(int i = 0 ; i<nums.length;i++)
       {
        
        int diff = target - nums[i];
        if(diff == nums[i])
            continue;
        int diffIndex;
        if(myMap.containsKey(diff))
        {
            diffIndex = myMap.get(diff);
            // arr = {i,diffIndex}; This statement is wrong as we can only use {} to instantiate an array when it' declared
            //Since now we want to instantiate when it's already declared we need to use the keyword 'new' and specify the type i.e int[]
            int lowerIndex = Math.min(i,diffIndex);
            int upperIndex = Math.max(i,diffIndex);
            arr = new int[]{lowerIndex,upperIndex};
            break;
        }
       }
       return arr;
    }
}