// import java.util.*;
// import java.io.*;

// public class Main
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();

//         int t = Integer.parseInt(br.readLine().trim());

//         int[][] arr = new int[t][2];
//         int i = 0;
//         while(t-- > 0)
//         {
//             StringTokenizer st = new StringTokenizer(br.readLine());

//             arr[i][0] = Integer.parseInt(st.nextToken());
//             arr[i][1] = Integer.parseInt(st.nextToken());

//             i++;

//         }

//         int res = eraseOverlapIntervals(arr);

//         sb.append(res);

//         System.out.print(sb);
//     }

//     public static int eraseOverlapIntervals(int[][] intervals) {

//         int len = intervals.length;

//         // if(len <= 1)
//         //     return 0;

//         Arrays.sort(intervals , (a,b) -> Integer.compare( a[1] , b[1] ));//Sorting by end times cuz we need to remove minimum elements 

//         int lastValidEndTime = intervals[0][1]; //Pushing first element

//         int removals = 0;

//         for(int i = 1 ; i < len ; i++)
//         {
//             if( intervals[i][0] < lastValidEndTime )
//             {
//                 removals++;
//                 continue;
//             }
//             lastValidEndTime = intervals[i][1];
//         }
//         return removals;
//     }

// }







class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        int len = intervals.length;

        // if(len <= 1)
        //     return 0;

        Arrays.sort(intervals , (a,b) -> Integer.compare( a[1] , b[1] ));//Sorting by end times cuz we need to remove minimum elements 

        int lastValidEndTime = intervals[0][1]; //Pushing first element

        int removals = 0;

        for(int i = 1 ; i < len ; i++)
        {
            if( intervals[i][0] < lastValidEndTime )
            {
                removals++;
                continue;
            }
            lastValidEndTime = intervals[i][1];
        }
        return removals;
    }
}







