class Solution {
    public List<String> letterCombinations(String digits) {

        //Array used as a Map for fast traversing
        String[] map = {"" , "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};

        StringBuilder sb = new StringBuilder();

        List<String> res = new ArrayList<>();

        if(digits.length() == 0)//Although the constraints said 1 < digits.length() < 4. But good practice to avoid edge cases
            return res;


        backtrack(0 , digits , sb , map , res);

        return res;
        
    }

    public void backtrack(int charIndex ,  String digits , StringBuilder sb , String[] map , List<String> res)
    {
        if(sb.length() == digits.length()) //Base case since "ad".length() = "23".length() = 2 save and return
        {
            res.add(sb.toString());//deep copy
            return;
        }

        //Stores the len of string returned from map, for eg: map[2] returns "abc" and the length of it is 3
        int digitLen = map[digits.charAt(charIndex) - '0'].length(); //map[Integer.parseInt("" + digits.charAt(charIndex))].length()
        for(int endIndex = 0; endIndex < digitLen ; endIndex++) //You need endIndex to start from 0 everytime so that u check 
        {//every possible scenario if u push it it params it would be wrong
            char ch = map[digits.charAt(charIndex) - '0'].charAt(endIndex);//Senior eng line 

            sb.append(ch);//Take it!
            backtrack(charIndex + 1 , digits , sb , map , res);//Explore
            sb.deleteCharAt(sb.length() - 1);//Backtrack
        }
    }
}
