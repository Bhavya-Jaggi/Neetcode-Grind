
class Solution 
{
    public boolean hasDuplicate(int[] nums) 
    {
    int i;
       Map<Integer,Integer> myMap = new HashMap<>();
       for(i = 0; i < nums.length ; i++)
       {
        int key = nums[i];
        if(myMap.containsKey(key))
            return true;
        else
            myMap.put(key, 1);
       }
       return false;
    }
}