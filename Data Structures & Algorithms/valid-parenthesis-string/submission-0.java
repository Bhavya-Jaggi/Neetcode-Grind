// import java.util.*;
// import java.io.*;

// class Main
// {
//     public static void main(String[] args) throws IOException
//     {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         StringBuilder sb = new StringBuilder();

//         String str = br.readLine().trim();

        

//         boolean t = checkValidString(str);

//         sb.append(t);

        
//         System.out.println(sb);

//     }
//     public static boolean checkValidString(String s) {

//         // if(s.equals("()"))
//         //     return true;

//         int len = s.length();

//         int sum = 0;

//         int count = 0;


//         //PrefixSum approach 
//         for(int i = 0 ; i < len ; i++)
//         {
//             char ch = s.charAt(i);

//             if(ch == '(')
//                 sum = sum + 1;
//             else if(ch == ')')
//                 sum -= 1;
//             else
//                 count++;

//             //Since sum is negative u cannot comapre it with a positive 'count' therefore you first check 
//             // if it has reached negative then check with absolute value of sum
//             //In simple terms it checks for "If ')' has come before '(' and we don't ahve enough '*' to counter it"
//             if(sum < 0 && Math.abs(sum) > count)
//                 return false;
//         }

//         count = 0;
//         sum = 0;

//         //SuffixSum approach
//         for(int i = len - 1 ; i > -1 ; i--)
//         {
//             char ch = s.charAt(i);


//             if(ch == '(')
//                 sum -= 1;
//             else if(ch == ')')
//                 sum += 1;
//             else
//                 count++;
            
//             if(sum < 0 && Math.abs(sum) > count) //Same logic but backwards
//                 return false;

//         }

//         return true; //If none of the above loops triggers false then it's true;
        
//     }
// }



class Solution {
    public boolean checkValidString(String s) {

        // if(s.equals("()"))
        //     return true;

        int len = s.length();

        int sum = 0;

        int count = 0;


        //PrefixSum approach 
        for(int i = 0 ; i < len ; i++)
        {
            char ch = s.charAt(i);

            if(ch == '(')
                sum = sum + 1;
            else if(ch == ')')
                sum -= 1;
            else
                count++;

            //Since sum is negative u cannot comapre it with a positive 'count' therefore you first check 
            // if it has reached negative then check with absolute value of sum
            //In simple terms it checks for "If ')' has come before '(' and we don't ahve enough '*' to counter it"
            if(sum < 0 && Math.abs(sum) > count)
                return false;
        }

        count = 0;
        sum = 0;

        //SuffixSum approach
        for(int i = len - 1 ; i > -1 ; i--)
        {
            char ch = s.charAt(i);


            if(ch == '(')
                sum -= 1;
            else if(ch == ')')
                sum += 1;
            else
                count++;
            
            if(sum < 0 && Math.abs(sum) > count) //Same logic but backwards
                return false;

        }

        return true; //If none of the above loops triggers false then it's true;
        
    }
}