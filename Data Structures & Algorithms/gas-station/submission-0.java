// import java.util.*;
// import java.io.*;

// public class Main
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();

//         int t = Integer.parseInt(br.readLine().trim());
    

//         int[] gas = new int[t];
//         int[] cost = new int[t];

//         StringTokenizer st = new StringTokenizer(br.readLine());
//         StringTokenizer ts = new StringTokenizer(br.readLine());

//         int i = 0;

//         while(t-- > 0)
//         {
//             gas[i] = Integer.parseInt(st.nextToken());
//             cost[i] = Integer.parseInt(ts.nextToken());
//             i++;
//         }

//         int res = canCompleteCircuit(gas , cost);

//         sb.append(res);

//         System.out.println(sb);
//     }
//     public static int canCompleteCircuit(int[] gas, int[] cost) {


//         int len = gas.length;
//         int start = -1;
//         int currGas = 0;
//         int flag = 0 , flag2 = 0;
        
//         for(int i = 0 ; i < len ; i++)
//         {
//             currGas += gas[i] - cost[i];

//             if(currGas < 0 && flag == 0)
//             {
//                 currGas = 0;
//                 start = -1;
//                 flag2 = 0;
//                 continue;
//             }

//             if(currGas >= 0 && flag2 == 0)
//             {
//                 start = i;
//                 flag2 = 1;
//             }

//             if(flag == 1 && start == i)
//                 break;
//             //Tou need to keep it BEFORE the just below 'if' condition cuz If not u will stick in infinite loop where you set i = -1 if your start is at last element cuz when u reach last element u do i = 1 while start = len -1 so they never equate 

//             if(i == len - 1)
//             {
//                 flag = 1;
//                 i = -1; //Don't set to i = 0; cuz if u do that the loop iterator immidiately does i++ so i = 1
//             } //basically u skipped i = 0 which is wrong

//             if(currGas < 0 && flag == 1)
//             {
//                 start = -1;
//                 break;
//             }

            
            
//         }

//         return start;
//     }
// }




class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {


        int len = gas.length;
        int start = -1;
        int currGas = 0;
        int flag = 0 , flag2 = 0;
        
        for(int i = 0 ; i < len ; i++)
        {
            currGas += gas[i] - cost[i];

            if(currGas < 0 && flag == 0)
            {
                currGas = 0;
                start = -1;
                flag2 = 0;
                continue;
            }

            if(currGas >= 0 && flag2 == 0)
            {
                start = i;
                flag2 = 1;
            }

            if(flag == 1 && start == i)
                break;
            //Tou need to keep it BEFORE the just below 'if' condition cuz If not u will stick in infinite loop where you set i = -1 if your start is at last element cuz when u reach last element u do i = 1 while start = len -1 so they never equate 

            if(i == len - 1)
            {
                flag = 1;
                i = -1; //Don't set to i = 0; cuz if u do that the loop iterator immidiately does i++ so i = 1
            } //basically u skipped i = 0 which is wrong

            if(currGas < 0 && flag == 1)
            {
                start = -1;
                break;
            }

            
            
        }

        return start;
    }
}