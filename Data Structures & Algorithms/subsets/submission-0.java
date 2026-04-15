// import java.util.*;
// import java.io.*;

// class Main
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();

//         int t = Integer.parseInt(br.readLine().trim());

//         int[] arr = new int[t];

//         StringTokenizer st = new StringTokenizer(br.readLine().trim() , "{}, ");

//         int i = 0;

//         while(t-- > 0)
//         {
//             arr[i++] = Integer.parseInt(st.nextToken());
//         }

//         List<List<Integer>> arrList = subsets(arr);

//         for(i = 0 ; i < arrList.size() ; i++)
//         {
//             sb.append(arrList.get(i)).append("\n");
//         }

//         System.out.println(sb.toString().trim());
//     }

    
//     public static List<List<Integer>> subsets(int[] nums) 
//     {

//         List<List<Integer>> res = new ArrayList<>();

//         List<Integer> currBox = new ArrayList<>();

//         backtrack(0 , nums , currBox , res);

//         return res;
        
//     }


//     private void backtrack(int index , int[] nums , List<Integer> currBox , List<List<Integer>> res)
//     {

//         if(index == nums.length) //The 'Base Case' as soon as you have reached the end of all the elements save
//         //everything and return
//         {
//             res.add(new ArrayList<>(currBox));//We do a 'deep-copy' here cuz java's ArrayList store data as
//             //references not as copy. So if we simply do res.add(currBox) res will store address to currBox not the
//             //actual data
            
//             return;
//         }

//         currBox.add(nums[index]); // This line means making a decision! I added the current element to the currBox 

//         // "Take it! Path"
//         backtrack(index+1 , nums , currBox , res); //This line freezes the current function call.
//         //This line bascially means "Now since i have added '1'(first element) to the 'currBox' show me all the
//         // possibilities which contains '1' as a subset {eg. [1],[1,2],[1,3],[1,2,3]}"

//         // As soon as the whole above tree is formed by successive recursive calls we come back to our original
//         // function which is this one  currBox = [1] (our first iteration) now this function unfreezes and we move 
//         //forward to execute the leftover function.

//         // "The Rewind (Actual Backtrack)"
//         currBox.remove(currBox.size() - 1); // This line just says that since above i have seen all the possibilities
//         // of having nums[index] {i.e. '1'}. So now remove the latest added element {'1'} and show me all the
//         //possibilities of not having '1' further down the tree

        
//         //Leave it PAth (This command is responsible for saving '[]' into res we don't manually add it)
//         backtrack(index+1 , nums , currBox , res);//Since now we are passing empty 'currBox' now we explore all the 
//         //possibilites of not having one down the tree {[2],[3],[2,3]}
//     }
// }











































class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> currBox = new ArrayList<>();

        backtrack(0 , nums , currBox , res);

        return res;
        
    }


    private void backtrack(int index , int[] nums , List<Integer> currBox , List<List<Integer>> res)
    {

        if(index == nums.length) //The 'Base Case' as soon as you have reached the end of all the elements save
        //everything and return
        {
            res.add(new ArrayList<>(currBox));//We do a 'deep-copy' here cuz java's ArrayList store data as
            //references not as copy. So if we simply do res.add(currBox) res will store address to currBox not the
            //actual data
            
            return;
        }

        currBox.add(nums[index]); // This line means making a decision! I added the current element to the currBox 

        // "Take it! Path"
        backtrack(index+1 , nums , currBox , res); //This line freezes the current function call.
        //This line bascially means "Now since i have added '1'(first element) to the 'currBox' show me all the
        // possibilities which contains '1' as a subset {eg. [1],[1,2],[1,3],[1,2,3]}"

        // As soon as the whole above tree is formed by successive recursive calls we come back to our original
        // function which is this one  currBox = [1] (our first iteration) now this function unfreezes and we move 
        //forward to execute the leftover function.

        // "The Rewind (Actual Backtrack)"
        currBox.remove(currBox.size() - 1); // This line just says that since above i have seen all the possibilities
        // of having nums[index] {i.e. '1'}. So now remove the latest added element {'1'} and show me all the
        //possibilities of not having '1' further down the tree

        
        //Leave it PAth (This command is responsible for saving '[]' into res we don't manually add it)
        backtrack(index+1 , nums , currBox , res);//Since now we are passing empty 'currBox' now we explore all the 
        //possibilites of not having one down the tree {[2],[3],[2,3]}
    }
}