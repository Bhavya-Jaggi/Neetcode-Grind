class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int len = s.length();
        boolean dp[] = new boolean[len + 1];

        dp[0] = true;

        Set<String> hashSet = new HashSet<>();

        for(String t : wordDict)
        {
            hashSet.add(t);
        }


        // 'i' is the LENGTH of the prefix we are currently checking
        for(int i = 1 ; i <= len ; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                String temp = s.substring(j , i);

                //"Chain Rule" dp[j] should be true and jo bhi uske baad hai vo 'dict' me hona chahiye 
                if(hashSet.contains(temp) && dp[j] == true)
                {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }
}