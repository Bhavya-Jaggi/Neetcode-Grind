class Solution {
    public int[] dailyTemperatures(int[] temp) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        

        int[] ans = new int[temp.length];

        int curr;

        for(int i = 0 ; i < temp.length ; i++)
        {
            curr = temp[i];

            while( !stack.isEmpty() && temp[stack.peek()] < curr)
            {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return ans;
    }
}