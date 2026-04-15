class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character , Integer> myMap = new HashMap<>();
        

        for(char j = 'A' ; j <= 'Z' ; j++)
        {
            myMap.put(j , 0);
        }

        int i,left = 0;
        int maxFreq = 0,size = 0;
        int cpy = k;
        int windowSize = 0;

        for(i = 0; i < s.length() ; i++)
        {
            char ch = s.charAt(i);
            myMap.put(ch , myMap.get(ch) + 1);

            maxFreq = Math.max(maxFreq , myMap.get(ch));

            windowSize = i - left + 1;

            if(windowSize - maxFreq > cpy)
            {
                char hc = s.charAt(left);
                myMap.put( hc , myMap.get(hc) - 1);
                left++;
            }
            else
            {
                size++;
            }




        }

        return size;

    }
}