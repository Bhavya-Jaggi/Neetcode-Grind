//Solely done by me!
class Solution {
    public void solve(char[][] board) {
        

        for(int i = 0 ; i < board.length ; i++) //Scan the board
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                //Onlu check for boundaries cuz rest all are trapped
                if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)
                {//If u find 'O' in the boundary it's SAFE sink it! and check for all chaining with it
                    if(board[i][j] == 'O')
                    {
                        dfs(i , j , board);
                    }
                }
            }

        }
        for(int i = 0 ; i < board.length ; i++) //Scanner for flipping all non-safe 'O' to 'X'
        {//Also flip the 'T' back to 'O'
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(int x , int y , char[][] board)
    {
        // Queue<int[]> queue = new LinkedList<>(); DFS problems don't need a queue

        //Out of bounds and non chaining 'O' are redundant check so filter them
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O')
            return;
        
        board[x][y] = 'T';//Since now it's guaranteed to be Boundary 'O' or chaining to a
        //boundary 'O' we can flip it to 'T' cuz it's safe 

        //We sink the curr safe 'O' -> 'T' then check on all four dirs for more chaining 'O'
        dfs(x + 1 , y , board);
        dfs(x - 1 , y , board);
        dfs(x , y + 1 , board);
        dfs(x , y - 1 , board);

    }
}