class Solution {
    public int climbStairs(int n) {

        if(n == 1)
            return 1;

        int tab[] = new int[n + 1];
        tab[1] = 1;
        tab[2] = 2;

        int i = 3;
        
        while(i <= n)
        {
            tab[i] = tab[i - 1] + tab[i - 2];
            i++;
        }
        return tab[n];
    }
}