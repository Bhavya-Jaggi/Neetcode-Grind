class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> arrList = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;

        


        while(i < intervals.length && intervals[i][1] < start)
        {
            arrList.add(intervals[i]);
            i++;
        }


        while(i < intervals.length && intervals[i][0] <= end)
        {
            start = Math.min(intervals[i][0] , start);
            end = Math.max(intervals[i][1] , end);
            i++;
        }

        arrList.add(new int[]{start , end});

        while(i < intervals.length)
        {
            arrList.add(intervals[i]);
            i++;
        }

        int[][] res = new int[arrList.size()][2];

        for(i = 0; i < arrList.size() ; i++)
        {
            res[i] = arrList.get(i);
        }

        return res;
        
    }
}