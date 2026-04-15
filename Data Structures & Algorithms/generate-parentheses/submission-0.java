class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        int openCount = 0;
        int closeCount = 0;
        
        backtrack(openCount , closeCount , sb , res , n);

        return res;
        
    }
    public void backtrack(int openCount , int closeCount , StringBuilder sb , List<String> res , int n)
    {
        if(sb.length() == 2 * n) //see the sample o/p if n = 3 then length of each String is n*2(6) so this
        // is our base case condition
        {
            res.add(sb.toString()); //to.String() OR new String(sb) is necessary!
            // sb.setLength(0);
            return;
        }
        if(closeCount < openCount) //First check this if this is 2nd 'if' check then u will get '!well-formed'
        //Paranthesis
        {
            sb.append(")");//Take it
            backtrack(openCount , closeCount + 1 , sb , res , n);//Explore
            sb.deleteCharAt(sb.length() - 1);// rewind
        }
        if(openCount < n)
        {
            sb.append("("); //Take it
            backtrack(openCount + 1 , closeCount , sb , res , n); // Explore
            sb.deleteCharAt(sb.length() - 1); //Rewind
        }
    }
}