class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new ArrayDeque<>();

        String str;

        for(int i = 0 ; i < tokens.length ; i++)
        {
            str = tokens[i];
            
            if(str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*"))
            {
                int eval = 0;
                int a = stack.pop();
                int b = stack.pop();
                if(str.equals("+"))
                {
                    eval = a + b;
                }
                else if(str.equals("-"))
                    eval = b - a;

                else if(str.equals("*"))
                    eval = a * b;

                else if(str.equals("/"))
                {
                    if(b != 0)
                    eval = b / a;
                }
                stack.push(eval);
            }
            else
            {
                int val = Integer.parseInt(str);
                stack.push(val);
            }

        }
        return stack.pop();

    }
}