/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;
        int res = 0;

        while(left <= right)
        {
            int mid = (right - left) / 2;
            mid += left;

            switch(guess(mid))
            {
                case 1 : left = mid + 1;
                break;
                case -1 : right = mid - 1;
                break;
                default : return mid;
            }
        }
        return 0;
    }
}