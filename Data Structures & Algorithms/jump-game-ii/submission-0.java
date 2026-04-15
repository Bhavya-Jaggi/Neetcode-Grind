// import java.util.*;
// import java.io.*;

// public class Main
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();

//         int t = Integer.parseInt(br.readLine().trim());

//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int arr[] = new int[t];

//         int  i = 0;

//         while(t-- > 0)
//         {
//             arr[i++] = Integer.parseInt(st.nextToken());
//         }

//         int res = jump(arr);

//         sb.append(res);

//         System.out.println(sb);
//     }

//     public static int jump(int[] nums) {

//         if(nums.length == 1)
//             return 0;
//         if(nums.length == 2)
//             return 1;

//         int maxValue = 0 , maxValueIndex = 0;
//         int step = 0;

//         for(int i = 0 ; i < nums.length ;) //Since you are setting i below no need for i++ here
//         {

//             if(i + nums[i] >= nums.length - 1)//This is a fix meant to dodge descending[3,2,1]arrays and if u 
//             {   // encounter a very big number [2,1,10,0,1] then 10 is lone sufficient to carry u to the end
//                 // So u skip firther useless clacs and print ans 
//                 step++;
//                 break;
//             }



//             maxValue = 0;
//             maxValueIndex = 0;


//             for(int j = 1 ; j <= nums[i] ; j++)// Here we are looping for nums[i] further jumps
//             {
//                 if(i + j >= nums.length -1)
//                     break;

//                 int currValue = nums[i+j] + (i+j); //we are seeking for max potential reach which is  
//                 // index + nums[i] i.e how far can any index take us relative to it's position
//                 if(currValue >= maxValue)
//                 {
//                     maxValue = currValue;
//                     maxValueIndex = i + j;
//                 }
                
//             }
//             step++;
//             if(maxValue >= nums.length - 1) // As soon as u find break away
//             {
//                 step++; //This is the final step we are taking from the element which leads us to last
//                 break;
//             }
//             i = maxValueIndex; //i++ is a waste of time jump from maxPotential to another maxPotential
            
            
//         }
//         return step;
//     }
// }






class Solution {
    public int jump(int[] nums) {

        if(nums.length == 1)
            return 0;
        if(nums.length == 2)
            return 1;

        int maxValue = 0 , maxValueIndex = 0;
        int step = 0;

        for(int i = 0 ; i < nums.length ;) //Since you are setting i below no need for i++ here
        {

            if(i + nums[i] >= nums.length - 1)//This is a fix meant to dodge descending[3,2,1]arrays and if u 
            {   // encounter a very big number [2,1,10,0,1] then 10 is lone sufficient to carry u to the end
                // So u skip firther useless clacs and print ans 
                step++;
                break;
            }



            maxValue = 0;
            maxValueIndex = 0;


            for(int j = 1 ; j <= nums[i] ; j++)// Here we are looping for nums[i] further jumps
            {
                if(i + j >= nums.length -1)
                    break;

                int currValue = nums[i+j] + (i+j); //we are seeking for max potential reach which is  
                // index + nums[i] i.e how far can any index take us relative to it's position
                if(currValue >= maxValue)
                {
                    maxValue = currValue;
                    maxValueIndex = i + j;
                }
                
            }
            step++;
            if(maxValue >= nums.length - 1) // As soon as u find break away
            {
                step++; //This is the final step we are taking from the element which leads us to last
                break;
            }
            i = maxValueIndex; //i++ is a waste of time jump from maxPotential to another maxPotential
            
            
        }
        return step;
    }
}