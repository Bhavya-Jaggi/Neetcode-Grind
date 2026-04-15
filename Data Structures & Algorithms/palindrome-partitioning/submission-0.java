class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        List<String> currWord = new ArrayList<>();

        backtrack(0 , s , currWord , res);

        return res;


        
    }

    public void backtrack(int startIndex , String s , List<String> currWord , List<List<String>> res)
    {
        if(startIndex == s.length()) //Base case, end of string save it and return 
        {
            res.add(new ArrayList<>(currWord));//Deep copy
            return;
        }
        //HEre startIndex is left(fixed) end of the siccors and endIndex is the right(moveable) end of the 
        // scissors to chop of the words
        for(int endIndex = startIndex ; endIndex < s.length() ; endIndex++)
        {
            if(isPalindrome(s , startIndex , endIndex)) //If condition magic
            {
                String str = s.substring(startIndex , endIndex + 1); //We don't do 'substring' untill we
                // are dead sure that it's a valid str cuz substring is heavy operations we don't waste CPU
                
                currWord.add(str); //Take it!
                backtrack(endIndex + 1 , s , currWord , res);//Explore
                //we pass endIndex here cuz we need to send the index where we left not where we started
                currWord.remove(currWord.size() - 1);//BackTrack!
            }
        }
        
    }

    public boolean isPalindrome(String str , int start , int end) //Basic Palindrome check helper function
    {
        while(start <= end)
        {
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}