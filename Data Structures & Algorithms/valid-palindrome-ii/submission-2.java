class Solution {
    public boolean validPalindrome(String s) {

        int len = s.length();
        int i = 0;
        int j = len - 1;

        while(i <= j)
        {
            char start = s.charAt(i);
            char end = s.charAt(j);

            if(start == end)
            {
                i++;
                j--;
            }
            //As soon as we find one mistake we call helper palindrome func which jsut checks palinrome 
            //in both the scenarios by skipping one 'i' or one 'j' if EITHER of them is true return true
            // Why EITHER ? cuz you idiot how can both the scenarios be true together?
            else
                return isPalindrome(i+1 , j , s) || isPalindrome(i , j - 1 , s);
        }
        return true; //If the loop ends we return true simply
    }

    public boolean isPalindrome(int i , int j , String s)
    {
        while(i <= j)
        {
            char start = s.charAt(i);
            char end = s.charAt(j);
            if(start == end)
            {
                i++;
                j--;
            }
            //Since we have already committed "at most one" removal any further removals are false
            else 
                return false;
        }
        return true;
    }
}