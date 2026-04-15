// import java.util.*;
// import java.io.*;

// class Main
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();

//         int t = Integer.parseInt(br.readLine().trim());

//         int[][] arr = new int[t][3];

//         int i = 0;

//         while(t-- > 0)
//         {
//             StringTokenizer st = new StringTokenizer(br.readLine());

//             arr[i][0] = Integer.parseInt(st.nextToken());
//             arr[i][1] = Integer.parseInt(st.nextToken());
//             arr[i][2] = Integer.parseInt(st.nextToken());

//             i++;
//         }

//         int[] target = new int[3];

//         StringTokenizer ts = new StringTokenizer(br.readLine());

//         target[0] = Integer.parseInt(ts.nextToken());
//         target[1] = Integer.parseInt(ts.nextToken());
//         target[2] = Integer.parseInt(ts.nextToken());

//         boolean res = mergeTriplets(arr , target);

//         sb.append(res);

//         System.out.println(sb);

//     }
//     public static boolean mergeTriplets(int[][] triplets, int[] target) {



//         int a = target[0];
//         int b = target[1];
//         int c = target[2];

//         if(triplets.length == 1) //Edge case wrap up
//         {
//             if(triplets[0][0] == a && triplets[0][1] == b && triplets[0][2] == c)
//                 return true;
//             else 
//                 return false;
//         }
//         int x = 0 , y = 0 , z = 0;

//         for(int i = 0 ; i < triplets.length ; i++)
//         {
//             int[] curr = triplets[i];

//             int aa = curr[0];
//             int bb = curr[1];
//             int cc = curr[2];

//             if(aa > a || bb > b || cc > c) //Remove whose any number > targets number cuz MAX() will not always be larger than the target then
//                 continue;
            
//             x = Math.max( x , aa); //MAX() with every valid triplet 
//             y = Math.max(y , bb);
//             z = Math.max(z , cc);
//             if(x == a && y == b && z == c)
//                 return true;
//         }

//         return false;
        
//     }
// }



class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {



        int a = target[0];
        int b = target[1];
        int c = target[2];

        if(triplets.length == 1) //Edge case wrap up
        {
            if(triplets[0][0] == a && triplets[0][1] == b && triplets[0][2] == c)
                return true;
            else 
                return false;
        }
        int x = 0 , y = 0 , z = 0;

        for(int i = 0 ; i < triplets.length ; i++)
        {
            int[] curr = triplets[i];

            int aa = curr[0];
            int bb = curr[1];
            int cc = curr[2];

            if(aa > a || bb > b || cc > c) //Remove whose any number > targets number cuz MAX() will not always be larger than the target then
                continue;
            
            x = Math.max( x , aa); //MAX() with every valid triplet 
            y = Math.max(y , bb);
            z = Math.max(z , cc);
            if(x == a && y == b && z == c)
                return true;
        }

        return false;
        
    }
}