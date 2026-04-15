class Solution {
    public int carFleet(int target, int[] pos, int[] speed) {

        int len = pos.length;
        double[][] cars = new double[len][2];
        // int fleet = 0;


        Deque<Double> stack = new ArrayDeque<>();
        

        for(int i = 0 ; i < len ; i++)
        {
            cars[i][0] = pos[i];
            cars[i][1] = (double)(target - pos[i]) / speed[i] ;
        }

        Arrays.sort(cars , (a,b) -> Double.compare(a[0] , b[0]));

        stack.push(cars[len-1][1]);

        for(int i = len - 2 ; i > -1 ; i--)
        {
            if(cars[i][1] > stack.peek())
            {
                stack.push(cars[i][1]);
            }
        }
        return stack.size();
    }
}