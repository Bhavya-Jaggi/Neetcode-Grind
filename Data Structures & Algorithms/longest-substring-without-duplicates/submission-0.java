class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> hashSet = new HashSet<>();
        boolean test;
        int size = 0,maxSize = 0,left = 0;

        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);
            test = hashSet.add(ch);
            if(!test)
            {
                char hc = s.charAt(left);
                while(ch != hc)
                {
                    hashSet.remove(hc);
                    left++;
                    size--;
                    hc = s.charAt(left);
                }
                hc = s.charAt(left);
                if(ch == hc)
                {
                    hashSet.remove(hc);
                    left++;
                }
                hashSet.add(ch);
            }
            else
                size++;

            if(size > maxSize)
                maxSize = size;
        }
    return maxSize;
    }
}