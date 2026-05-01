class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int dpOne = 0;
        int dpTwo = 0;
        int sum = 0;

        for(int i = 2 ; i <= cost.length ; i++)
        {
            sum = Math.min((dpOne + cost[i - 1]) , (dpTwo + cost[i - 2]));
            dpTwo = dpOne;
            dpOne = sum;
        }
        return sum;
    }
}