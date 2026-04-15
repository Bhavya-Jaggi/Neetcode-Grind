class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> currList = new ArrayList<>();

        Arrays.sort(nums); //Needed so that same numbers sit next to each other. Mandatory for pruning.

        backtrack(0 , nums , currList , res);

        return res;
        
    }

    public void backtrack(int index , int[] nums , List<Integer> currList , List<List<Integer>> res)
    {
        res.add(new ArrayList<>(currList)); //In subsets problem we need every possible state isliye DeepCopy
        //at the very start (This is the goal)
        for(int i = index ; i < nums.length ; i++)//Horizontal scanner to choose choices left to right 
        {
            if(i > index && nums[i] == nums[i-1])//The Pruning line, i > index ensures that it's never the
            //first element and the second condition states that if two consecutive numbers are same no need
            //to do anything    
                continue;
            currList.add(nums[i]);//Take it!
            backtrack(i + 1, nums , currList , res);//Explore
            currList.remove(currList.size() - 1);//Backtrack
            
            
        }
    }
}