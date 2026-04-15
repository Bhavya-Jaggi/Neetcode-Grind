class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map <Integer , Integer> myMap = new HashMap<>(nums.length);

        int huh;

        int[] arr = new int[2];


        for(int i = 0 ; i < nums.length ; i++)
        {
            huh = target - nums[i];
            if(myMap.containsKey(huh))
            {
                arr[0] = myMap.get(huh)+1;
                arr[1] = i + 1;
                break;
            }
            else
                myMap.put(nums[i] , i);
        }

        return arr;

    }
}