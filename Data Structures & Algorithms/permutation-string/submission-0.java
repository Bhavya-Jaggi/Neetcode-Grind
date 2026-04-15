class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int len = s1.length();
        // int k = 0,temp;
        // int left = 0, right = len - 1;
        int[] arr = new int[26];
        int[] res = new int[26];


        if(s1.length() > s2.length())
            return false;

        for(int i = 0; i < len ; i++)
        {
            char ch = s1.charAt(i);
            arr[ch - 'a']++;
            char hc = s2.charAt(i);
            res[hc - 'a']++;
        }
        if(Arrays.equals(arr,res))
            return true;
        
        
        for(int i = len ; i < s2.length() ; i++)
        {
            res[s2.charAt(i-len) - 'a']--;
            char ch = s2.charAt(i);
            res[ch - 'a']++;
            if(Arrays.equals(arr , res))
                return true;
        }
        return false;

    }
}