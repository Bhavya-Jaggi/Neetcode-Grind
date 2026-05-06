class Solution {
    public int countSubstrings(String s) {
        
        int len = s.length();

        int count = 0;//Total count

        for(int i = 0 ; i < len ; i++)
        {
            //Note we add to count both times for all possibilities

            count += expandAroundCenter(i , i , s); //Odd explansion we expand around a char

            count += expandAroundCenter(i , i + 1 , s);//Even expansion we expand around the mid space 
            //between two characters and we mandatorily make it two chars by passing 'i' & 'i+1'
        }

    return count;
    }

    public int expandAroundCenter(int left , int right , String str)
    {
        int count = 0;
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right))
        {
            count++;
            left--;//Don't do -- we need to EXPAND 
            right++;//Same logic push the pointers to thier limits
        }
        return count;
    }
}