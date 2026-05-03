//Naive solution without DP
class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();
        int maxLen = 0;
        String res = "";

        for(int i = 0 ; i < len ; i++)
        {
            char ch = s.charAt(i);
            for(int j = i ; j < len ; j++)
            {
                char hc = s.charAt(j);
                if(ch == hc)
                {
                    if(isPalindrome(s , i , j))
                    {
                        if(maxLen < (j - i + 1))
                        {
                            res = s.substring(i , j + 1);
                            maxLen = j - i + 1;    
                        }
                    }
                }
            }
        }
        return res;
        
    }

    public boolean isPalindrome(String str , int start , int end)
    {
        while(start <= end)
        {
            char ch = str.charAt(start);
            char hc = str.charAt(end);

            if(ch == hc)
            {
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }
}