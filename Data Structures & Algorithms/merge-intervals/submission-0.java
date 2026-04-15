class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> arrList = new ArrayList<>();

        int i = 0;
        int[] lastMergedInterval;
        int len = intervals.length;


        if(len <= 1)
            return intervals;

        // First we sort the intervals[][] so that we can implement O(NlogN) instead of O(n^2)

        Arrays.sort(intervals , (a,b) -> Integer.compare( a[0] , b[0] ));

        arrList.add(intervals[0]);

        //Since now it's sorted we proceed further to implement merging logic

        for(int[] currInterval : intervals)
        {
            int[] lastMergedElement = arrList.get(arrList.size() - 1);
            int currIntervalStart = currInterval[0];

            if(currIntervalStart <= lastMergedElement[1])
            {
                //Since the interval is already in the list don't add it to the list just update the end
                //Why don't we update the start? Since we already sorted the intervals[][] so start will
                // be equal or less than so it doesn't matter

                lastMergedElement[1] = Math.max(currInterval[1] , lastMergedElement[1]);
            }
            else
                arrList.add(currInterval);
        }

        return arrList.toArray(new int[arrList.size()][]);


        // Use below snippet if u forget the above line!
        // int[][] res = new int[arrList.size()][];
        // for(int[] element : arrList)
        // {
        //     res[i] = element;
        //     i++;
        // }

        // return res;
        
    }
}