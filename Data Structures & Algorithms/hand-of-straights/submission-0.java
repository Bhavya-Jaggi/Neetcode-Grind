// import java.util.*;
// import java.io.*;

// class Main
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();

//         StringTokenizer st = new StringTokenizer(br.readLine().trim());

//         int[] arr = new int[Integer.parseInt(st.nextToken())];
//         int size = Integer.parseInt(st.nextToken());

//         StringTokenizer ts = new StringTokenizer(br.readLine());

//         int len = arr.length;

//         int i = 0;

//         while(len-- > 0)
//         {
//             arr[i++] = Integer.parseInt(ts.nextToken());
//         }

//         boolean t = isNStraightHand(arr , size);

//         sb.append(t);

//         System.out.println(sb);

//     }

//     public static boolean isNStraightHand(int[] hand, int groupSize) {

//         if(hand.length % groupSize != 0) //If array's size is not a multiple of groupSize it's FALSE
//             return false;

//         Arrays.sort(hand); //Sorting cuz we need to find consequtives

//         Map<Integer , Integer> freqMap = new HashMap<>();

//         for(int i = 0 ; i < hand.length ; i++) //Populating map
//         {
//             if(freqMap.containsKey(hand[i]))
//                 freqMap.put(hand[i] , freqMap.get(hand[i])  + 1);
//             // freqMap.put(hand[i], freqMap.getOrDefault(hand[i], 0) + 1); Better approach
//             else
//                 freqMap.put(hand[i] , 1);
//         }

//         for(int i = 0 ; i < hand.length ; i++) //Dry run this loop yourself to understand 
//         {
//             int key = hand[i];
//             if( freqMap.get(key) > 0)
//             {
//                 for(int j = 1 ; j < groupSize ; j++) //Iterating for making groups considering we already have 1 consequtive element 
//                 {
//                     if(freqMap.containsKey( key + j ) && freqMap.get(key + j) > 0)
//                         freqMap.put( key + j  , freqMap.get(key+j) - 1);
//                     else 
//                         return false;
//                 }
//                 freqMap.put(key , freqMap.get(key) - 1); //Decreasing the key's freq too!
//             }
//         }
//         return true; //If nothing breaks it's true;
//     }
// }





class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0) //If array's size is not a multiple of groupSize it's FALSE
            return false;

        Arrays.sort(hand); //Sorting cuz we need to find consequtives

        Map<Integer , Integer> freqMap = new HashMap<>();

        for(int i = 0 ; i < hand.length ; i++) //Populating map
        {
            if(freqMap.containsKey(hand[i]))
                freqMap.put(hand[i] , freqMap.get(hand[i])  + 1);
            // freqMap.put(hand[i], freqMap.getOrDefault(hand[i], 0) + 1); Better approach
            else
                freqMap.put(hand[i] , 1);
        }

        for(int i = 0 ; i < hand.length ; i++) //Dry run this loop yourself to understand 
        {
            int key = hand[i];
            if( freqMap.get(key) > 0)
            {
                for(int j = 1 ; j < groupSize ; j++) //Iterating for making groups considering we already have 1 consequtive element 
                {
                    if(freqMap.containsKey( key + j ) && freqMap.get(key + j) > 0)
                        freqMap.put( key + j  , freqMap.get(key+j) - 1);
                    else 
                        return false;
                }
                freqMap.put(key , freqMap.get(key) - 1); //Decreasing the key's freq too!
            }
        }
        return true; //If nothing breaks it's true;
    }
}