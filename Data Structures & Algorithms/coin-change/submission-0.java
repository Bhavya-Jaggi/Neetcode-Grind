class Solution {
    public int coinChange(int[] coins, int amt) {

        if(amt == 0)
            return 0;

        int len = coins.length;
        
        
        int[] dp = new int[amt + 1];// We will calculate coins for every i
        Arrays.fill(dp , amt + 1);
        Arrays.sort(coins);//Since now sorted we can use the 'break' ahead

        dp[0] = 0;

        for(int i = 1 ; i <= amt ; i++)//Looping thrugh each element of the arr utill amt
        {
            for(int j = 0 ; j < len ; j++)//Looping through coins
            {
                if(coins[j] > i)
                    break;
                dp[i] = Math.min(dp[i] , 1 + dp[i - coins[j]]);//This works i don't fully 
                //Understand tho
            }
        }
        return dp[amt] > amt ? -1 : dp[amt]; //If the amount is impossible we have to return
        // -1 and we can only check that if there is default infinity(amt + 1) in our dp[i]
        // if that is the case we return -1
    }
}