class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> arrList = new ArrayList<>();

        List<Integer> currList = new ArrayList<>();

        backtrack(0 , candidates , currList , arrList , target);

        return arrList;



    }

    public void backtrack(int index , int[] arr , List<Integer> currList , List<List<Integer>> res , int target)
    {
        int currSum = sum(currList);
        if(currSum == target) //goalReached?
        {
            res.add(new ArrayList<>(currList)); //DeepCopy
            return;
        }
        else if(currSum > target) //PruningCodn
            return;
        
        for(int i = index ; i < arr.length ; i++)//The choice loop
        {
            if(arr[i] <= target) //isValidChoice
            {
                currList.add(arr[i]); //Take it!
                backtrack(i , arr , currList , res , target); //Move Forward
                currList.remove(currList.size() - 1);//Backtrack
            }

        }
    }

    public int sum(List<Integer> arr)
    {
        int sum = 0;
        for(Integer element : arr)
        {
            sum += element;
        }
        return sum;
    }
}