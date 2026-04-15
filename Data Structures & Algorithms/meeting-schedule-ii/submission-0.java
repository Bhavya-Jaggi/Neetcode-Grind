/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        
        int len = intervals.size();
        int[] startArr = new int[len];
        int[] endArr = new int[len];
        int rooms = 0;

        for(int i = 0 ; i < len ; i++)
        {
            startArr[i] = intervals.get(i).start;
            endArr[i] = intervals.get(i).end;
        }

        // U need custom comparator for Objects or 2D arrays 1D arrays can be sorted just as is
        // Arrays.sort(startArr , (a,b) -> Integer.compare(a, b));
        // Arrays.sort(endArr , (a , b) -> Integer.compare(a,b));

        Arrays.sort(startArr);
        Arrays.sort(endArr);

        int i = 0,j=0;
        while(i < len)
        {
            if(startArr[i] < endArr[j])
                rooms++;            
            else
                j++;
            i++;
        }

        return rooms;
    }
}
