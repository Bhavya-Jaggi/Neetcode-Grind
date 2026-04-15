class Solution {
    public boolean isValid(String s) {
        
       Deque<Character> charStack = new ArrayDeque<>();


       for(int i = 0 ; i < s.length() ; i++)
       {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{')
            {
                charStack.push(ch);
            }
            else if( 
                (ch == ')'  && !charStack.isEmpty() && charStack.peek() == '(') ||
                (ch == '}'  && !charStack.isEmpty() && charStack.peek() == '{') ||
                (ch == ']'  && !charStack.isEmpty() && charStack.peek() == '[') 
            )
            {
                charStack.pop();
            }
            else
                return false;
       }
       if(!charStack.isEmpty())
        return false;
    return true;

    }
}