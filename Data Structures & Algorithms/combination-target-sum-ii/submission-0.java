class Solution {

    Set<List<Integer>> hashSet = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> currList = new ArrayList<>();

        Arrays.sort(candidates); //nO NEED  for any Hashset just do this and you are good to go!

        backtrack(0 , candidates , currList , res , target);

        return res;
    }

    public void backtrack(int index , int[] arr , List<Integer> currList , List<List<Integer>> res , int target)
    {
        int currSum = sum(currList);

        if(currSum == target) //goalMet?
        {
            // Collections.sort(currList , (a,b) -> Integer.compare(a,b) );
            // boolean t = hashSet.add(new ArrayList<>(currList) );
            // if(t)
            res.add(new ArrayList<>(currList)); //DeepCopy and add to res
            return;
        }
        else if(currSum > target) //Pruning Condition 
            return;
        
        for(int i = index ; i < arr.length ; i++) //Our standard loop
        {
            if(i > index && arr[i] == arr[i-1])//If duplicate number don't build same tree just to get rejected
                continue; //Pruning Condition #2

            
            if(arr[i] <= target) //isValidChoice?
            {
                currList.add(arr[i]); //Take it!
                backtrack(i+1 , arr , currList , res , target); //Move forward with i + 1
                currList.remove(currList.size() - 1); //BackTrack!
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