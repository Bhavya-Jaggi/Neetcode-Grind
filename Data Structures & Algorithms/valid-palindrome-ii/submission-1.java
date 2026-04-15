// WHY TF DID I DO THIS LIKE THIS DON'T DO IT THIS WAY DO IT THE BOOK WAY
class Solution {
    public boolean validPalindrome(String s) {
        int len = s.length();
        int i = 0, j = len - 1;

        while (i <= j) {
            char start = s.charAt(i);
            char end = s.charAt(j);

            if (start == end) {
                i++;
                j--;
            } else {
                // MISMATCH FOUND! The main loop is done. 
                // Now we independently test Path 1 and Path 2.

                // --- PATH 1: Skip Left Character ---
                boolean path1Success = true;
                int left1 = i + 1;
                int right1 = j;
                
                while (left1 <= right1) {
                    if (s.charAt(left1) == s.charAt(right1)) {
                        left1++;
                        right1--;
                    } else {
                        path1Success = false; // It failed!
                        break;
                    }
                }
                
                if (path1Success) {
                    return true; // Path 1 survived all the way through
                }

                // --- PATH 2: Skip Right Character (Only runs if Path 1 failed) ---
                boolean path2Success = true;
                int left2 = i;
                int right2 = j - 1;
                
                while (left2 <= right2) {
                    if (s.charAt(left2) == s.charAt(right2)) {
                        left2++;
                        right2--;
                    } else {
                        path2Success = false; // It failed!
                        break;
                    }
                }
                
                if (path2Success) {
                    return true; // Path 2 survived all the way through
                }

                // If we get here, BOTH paths hit a mismatch. 
                return false; 
            }
        }
        
        return true; // The original string was a perfect palindrome
    }
}