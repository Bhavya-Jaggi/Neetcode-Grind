class Solution {

    HashSet<String> hashSet = new HashSet<>(); //One to save success and save time
    HashSet<String> failure = new HashSet<>(); //One to save failures too Memoization works both ways!

    public int countSubstrings(String s) {

        int len = s.length();

        int count = 0;

        for(int i = 0 ; i < len ; i++)//Just bruteforcing!
        {
            for(int j = i ; j < len ; j++)
            {
                count += isPalindrome(i , j , s);
            }
        }
        return count;
    }

    public int isPalindrome(int left , int right , String str)
    {
        String res = str.substring(left , right + 1);// Super Massive overhead! O(n) per string

        //Memoization put into work!
        if(hashSet.contains(res)) 
            return 1;
        else if(failure.contains(res))
            return 0;


        //Basic Palindrome check
        while(left <= right)
        {
            if( !(str.charAt(left) == str.charAt(right)) ) //IF chars mismatch add to failure
            {
                failure.add(res);
                return 0;//and don't increase the count cuz this ain't a valid substring
            }
            left++;
            right--;
        }

        //Since 'res' passed the palindrome filter we add this as a success and return 1 for 'count'
        hashSet.add(res);
        return 1;
    }
}