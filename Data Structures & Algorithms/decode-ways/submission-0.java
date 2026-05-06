class Solution {
    public int numDecodings(String s) {

        if(s.charAt(0) == '0') //Any leading zero's is a dead end
            return 0;

        int len = s.length();

        int[] dp = new int[len+1]; //Len + 1 is crucial cuz final ans is in last place

        dp[0] = 1;//One way to choose the string is to not choose anything therefore dp[0] = 1
        
        dp[1] = 1; //We did this cuz we can only choose 1st cha of String ONLY 1 time 

        for(int i = 2 ; i <= len ; i++)
        {
            char ch = s.charAt(i - 1); //Curr char since 'i' is one more to adjust
            char hc = s.charAt(i - 2); //Prev char

            int num = ch - '0';
            int prev = hc - '0'; //Don't do Integer.parseInt("" + hc) it's expensive 

            if(num > 0 && num < 10)
            {
                dp[i] += dp[i - 1];
            }
            if( ((prev * 10) + num) >= 10 && ((prev * 10) + num) <= 26 )
            {
                dp[i] += dp[i - 2];
            }

        }
        return dp[len];
    }
}