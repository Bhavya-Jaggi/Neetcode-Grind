class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int currSize = 0;

        int len = s.length();

        int left = 0;
        int right = 0 ;

        Set<Character> window = new HashSet<>();

        while(right < len)
        {
            if(!window.contains(s.charAt(right)))
            {
                window.add(s.charAt(right));
                right++;
                currSize = right - left;
                if(currSize > max)
                    max = currSize;
            }
            else
            {
                window.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }
}