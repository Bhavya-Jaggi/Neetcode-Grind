class Solution {
    public int mySqrt(int x) {

        if(x == 1)
            return 1;
        if(x == 0)
            return 0;

        
        int res = 1;

        int i = 1;
        int j = x;
        

        while(i <= j)
        {
            int mid = i + (j - i) / 2; //Prevents overflow and is same as (i + j) / 2;
            long square = (long)mid * mid; //You have to expicitely type cast to long
            if(square == x)
            {
                res = mid;
                break;
            }
            else if(square > x)
                j = mid - 1;
            else
            {
                res = mid;
                i = mid + 1;
            }
        }
        return res;
    }
}