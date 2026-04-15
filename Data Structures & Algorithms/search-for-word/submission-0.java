class Solution {
    public boolean exist(char[][] board, String word) {

        char ch = word.charAt(0);

        StringBuilder sb = new StringBuilder();

        char[][] upBoard = new char[board.length + 2][board[0].length + 2]; //Draw on paper to find dimensions

        for(int i = 1 ; i < upBoard.length - 1 ; i++) //Padding the matrix with '0' boundary
        {
            for(int j = 1 ; j < upBoard[0].length - 1 ; j++)
            {
                upBoard[i][j] = board[i - 1][j - 1]; //Easy to write when drawn on paper
            }
        }

        for(int i = 0 ; i < upBoard.length ; i++)
        {
            for(int j = 0 ; j < upBoard[0].length ; j++)
            {
                if(upBoard[i][j] == ch)
                {
                    sb.append(ch);//Add the found letter to the sb BEFORE you backtrack if not the n u will send sb = ""
                    upBoard[i][j] = '0'; //Deface the first letter found

                    if( backtrack(i , j , sb , word, 1 , upBoard) )//Notice this marvelous statement executing backtracking 
                        return true; //as soon as you find a match return immidiately 

                    //Since you reached here that means backtrack 'Failed'
                    sb.deleteCharAt(sb.length() - 1);//Clean the 'sb'
                    upBoard[i][j] = ch;//Re-write the Defaced value back
                    
                }
                //If by any chance we fail the 'j' loop we go on with 'i' loop to discover all possibilities
            }
        }
        
        return false; //Only used when above loop didn't return true under all possibilities
    }

    public boolean backtrack(int i , int j , StringBuilder sb , String word , int indexCh , char[][] arr)// Note the return type
    {

        if(word.equals(sb.toString()) && word.length() == indexCh)//2nd condition is only real check 1st one is showpiece
        {
            return true;
        }
        
        char ch = word.charAt(indexCh); //This should be after the base case cuz if not 'indexOutOfBounds' awaits 


        if(arr[i][j - 1] == ch) //Left condition
        {
            sb.append(ch); //Append
            arr[i][j - 1] = '0';//Deface
            boolean temp = backtrack(i , j-1 , sb , word , indexCh + 1 , arr); //Backtrack
            if(temp)
                return true; //Did we succeed? return success immidiately 

            
            arr[i][j-1] = ch;//Since we didn't succeed we re-write the defaced value
            sb.deleteCharAt(sb.length() - 1);//Since we didn't succeed we reset the 'sb'
        }
        if(arr[i - 1][j] == ch) //Up condition
        {
            sb.append(ch);
            arr[i-1][j] = '0';
            boolean temp = backtrack(i - 1 , j , sb , word , indexCh + 1 , arr);
            if(temp)
                return true;
            arr[i-1][j] = ch;
            sb.deleteCharAt(sb.length() - 1);
        }
        if(arr[i][j + 1] == ch) //Right condition
        {
            sb.append(ch);
            arr[i][j+1] = '0';
            boolean temp = backtrack( i , j + 1 , sb , word, indexCh + 1 , arr);
            if(temp)
                return true;
            arr[i][j + 1] = ch;
            sb.deleteCharAt(sb.length() - 1);
        }
        if(arr[i + 1][j] == ch) //Down condition
        {
            sb.append(ch);
            arr[i+1][j] = '0';
            boolean temp = backtrack(i + 1 , j , sb , word , indexCh + 1 , arr);
            if(temp)
                return true;
            arr[i+1][j] = ch;
            sb.deleteCharAt(sb.length() - 1);
        }
        return false; //Since none of the "if's" triggered that means we were not able to find the adjescent block therefore our
        // inner 'j' loop in the above scanner method(exits) has failed therefore we move to next iteration of j then onwards i
    }
}