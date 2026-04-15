// import java.util.*;
// import java.io.*;

// public class Main
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();

//         int t = Integer.parseInt(br.readLine().trim());

//         int[] arr = new int[t];

//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int i = 0;

//         while(t-- > 0)
//         {
//             arr[i++] = Integer.parseInt(st.nextToken());
//         }

//         int res = maxSubArray(arr);

//         sb.append(res);

//         System.out.print(sb);
//     }

//     public static int maxSubArray(int[] nums) {
        
//         int maxSum = Integer.MIN_VALUE , currSum = 0;

//         for(int num : nums)
//         {
//             currSum += num;

//             if(currSum > maxSum) //This should be before lower 'if' Since an all negative arr [-2,-3] would
//                 maxSum = currSum;  //never return a value 
            
            
//             if(currSum < 0)
//                 currSum = 0;
            
            

//         }

//         return maxSum;
//     }

// }





class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = Integer.MIN_VALUE , currSum = 0;

        for(int num : nums)
        {
            currSum += num;

            if(currSum > maxSum) //This should be before lower 'if' Since an all negative arr [-2,-3] would
                maxSum = currSum;  //never return a value 
            
            
            if(currSum < 0)
                currSum = 0;
            
            

        }

        return maxSum;
    }
}



