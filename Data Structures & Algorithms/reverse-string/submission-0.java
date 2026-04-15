class Solution {
    public void reverseString(char[] s) {
        char temp;
        int len = s.length;
        int i = 0;
        int j = len - 1;

        while(i < j)
        {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
            
    }
}