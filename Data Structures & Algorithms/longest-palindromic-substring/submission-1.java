//Approach good but solution is not optimal
class Solution {
    public String longestPalindrome(String s) {

        int left,right;
        int len = s.length();
        int maxLen = 0;
        String res = "";
        String p = "", q = "";

        //No need for 2 for loops too much garbage just use Java's speciality that is accessing objects
        //via reference!
        for(int i = 0 ; i < len ; i++)
        {
            String t = iNeedHelp(s , i , i);
            if(t.length() > maxLen)
            {
                maxLen = t.length();
                q = t;
            }
        }
        
        maxLen = 0;

        for(int i = 0 ; i < len ; i++)
        {
            String t = iNeedHelp(s , i , i+1);
            if(t.length() > maxLen)
            {
                maxLen = t.length();
                p = t;
            }
        }

        return q.length() > p.length() ? q : p;
    }

    //This function believes that the string is Palindrome as sent by the caller and expands outwards
    //As soon as the 's' is not palindrome or out of bounds the function breaks and returns the last   
    //valid palindrome 'res'
    public String iNeedHelp(String s , int left , int right)
    {
        // int left,right;
        int len = s.length();
        int maxLen = 0;
        String res = "";
        while( (left >= 0 && right < len) && s.charAt(left) == s.charAt(right) )
        {
            if(maxLen < right - left + 1)
            {
                maxLen = right - left + 1;
                res = s.substring(left , right + 1);
            }
            left--;
            right++; 
        }
        return res;
    }
}