// import java.util.*;
// import java.io.*;

// class Main
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();

//         String str = br.readLine().trim();

//         List<Integer> arrList = partitionLabels(str);

//         int len = arrList.size();

//         int i = 0;

//         while(len-- > 0)
//         {
//             sb.append(arrList.get(i++)).append(" ");
//         }

//         System.out.println(sb);

//     }
//     public static List<Integer> partitionLabels(String s) {

//         int arr[] = new int[26];
        
//         int count = 0;
//         List<Integer> res = new ArrayList<>();

//         for(int i = 0 ; i < s.length() ; i++) //Populating the array
//         {
//             char ch = s.charAt(i);

//             arr[ch - 'a']++;
//         }

//         Set<Character> hashSet = new HashSet<>(); //We are building this cuz this will help us determine if 
//         // we have successfully completed scanning a specific group.

//         for(int i = 0 ; i < s.length() ; i++)
//         {
//             char ch = s.charAt(i);

//             hashSet.add(ch); //If it's a new character add it to HashSet

//             count++; //Counting the number of elements per label

//             arr[ch - 'a']--; //Decreamenting ch's freq


//             if(arr[ch - 'a'] == 0) //After decrementing we check if it's freq has dropped to 0 then remove it 
//                 hashSet.remove(ch); //from our hashset 
            
//             if(arr[ch - 'a'] == 0 && hashSet.size() == 0) //Since now the last character is removed so if the
//             { //hashSet is also empty we found our first lable with 'count' characters so we add it to 'res'
                
//                 res.add(count);
//                 count = 0;
//             }
            

//         }
//         return res;
//     }

// }




class Solution {
    public List<Integer> partitionLabels(String s) {

        int arr[] = new int[26];
        
        int count = 0;
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < s.length() ; i++) //Populating the array
        {
            char ch = s.charAt(i);

            arr[ch - 'a']++;
        }

        Set<Character> hashSet = new HashSet<>(); //We are building this cuz this will help us determine if 
        // we have successfully completed scanning a specific group.

        for(int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);

            hashSet.add(ch); //If it's a new character add it to HashSet

            count++; //Counting the number of elements per label

            arr[ch - 'a']--; //Decreamenting ch's freq


            if(arr[ch - 'a'] == 0) //After decrementing we check if it's freq has dropped to 0 then remove it 
                hashSet.remove(ch); //from our hashset 
            
            if(arr[ch - 'a'] == 0 && hashSet.size() == 0) //Since now the last character is removed so if the
            { //hashSet is also empty we found our first lable with 'count' characters so we add it to 'res'
                
                res.add(count);
                count = 0;
            }
            

        }
        return res;
    }
}