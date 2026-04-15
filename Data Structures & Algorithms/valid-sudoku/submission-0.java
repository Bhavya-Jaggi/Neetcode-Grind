class Solution {
    public boolean isValidSudoku(char[][] board) {
        final Map<Character , Integer> myMap = new HashMap<>();//final keyword used by Pros to clear HashMaps when not creating another one
        

        for(int i = 0; i < 9; i++) //Row-Wise check
        {
            for(int j=0; j < 9; j++)
            {
                char ch = board[i][j];

                if(ch == '.')
                    continue;

                if(myMap.containsKey(ch))
                    return false;
                else
                    myMap.put(ch , 1);
            }
            myMap.clear(); //Empties the map but preserves the address for future use
        }
        myMap.clear();


        for(int i = 0; i < 9 ; i++)     //Column-Wise check
        {
            for(int j = 0; j < 9; j++)
            {
                char ch = board[j][i];

                if(ch == '.')
                    continue;
                if(myMap.containsKey(ch))
                    return false;
                else
                    myMap.put(ch, 1);
            }
            myMap.clear();
        }
        myMap.clear();

        
        for(int k = 0; k < 9; k++)
        {
            int row = (k / 3) *3;
            int col = (k % 3) * 3;
            for(int i = 0 ; i < 3; i ++)
            {
                for(int j = 0; j < 3; j++)
                {
                    char ch = board[i + row][j + col];

                    if(ch == '.')
                        continue;
                    if(myMap.containsKey(ch))
                        return false;
                    else
                        myMap.put(ch , 1);
                }
            }
            myMap.clear();
        }

        return true;
    }
}