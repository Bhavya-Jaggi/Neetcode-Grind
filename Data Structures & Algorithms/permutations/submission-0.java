class Solution {
    
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> currList = new ArrayList<>();

        backtrack(currList , res , nums);//Actually there is no need index

        return res;
        
    }

    public void backtrack(List<Integer> currList , List<List<Integer>> res , int[] nums)
    {
        if(currList.size() == nums.length)  //Base case 
        {
            res.add(new ArrayList<>(currList));
            return;
        }
        
        for(int i = 0 ; i < nums.length ; i++) //Note we don't need 'Index' cuz that would give us 
        { //Combinations not permutations 
            
            if(!currList.contains(nums[i])) //If number already present skip(Done to stop making [1,1,1])
            {
                currList.add(nums[i]);
                backtrack(currList , res , nums);
                currList.remove(currList.size() - 1);
            }
        }
    }
}