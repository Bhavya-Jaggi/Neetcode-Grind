class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();

        List<String> currRow = new ArrayList<>();

        char[][] chessBoard = new char[n][n];


        for(int i = 0 ; i < n ; i++)
        {
            Arrays.fill(chessBoard[i], '.');
        }

        
        backtrack(0 , n , chessBoard , res);

        return res;


        
    }

    public void backtrack(int rows , int n ,char[][] chessBoard , List<List<String>> res)
    {
        if(rows == n)
        {
            List<String> currRow = new ArrayList<>();
            for(int i = 0 ; i < n ; i++)
            {
                currRow.add(new String(chessBoard[i]));
            }
            res.add(currRow);
            return;
        }
        for(int col = 0 ; col < n ; col++)
        {
            if(isSafe(chessBoard , rows , col))
            {
                chessBoard[rows][col] = 'Q';
                backtrack(rows + 1 , n , chessBoard , res);
                chessBoard[rows][col] = '.';
            }
        }
        
    }
    

    public boolean isSafe(char[][] chessBoard , int row , int col)
    {
        //North-check
        for(int r = row ; r >= 0 ; r--)
        {
            if(chessBoard[r][col] == 'Q')
                return false;
        }
        //North West check
        int r = row;
        int c = col;
        while(r >= 0 && c>= 0)
        {
            if(chessBoard[r][c] == 'Q')
                return false;
            r--;
            c--;
        }
        //North-East check
        r = row;
        c = col;
        while(r >= 0 && c < chessBoard.length)
        {
            if(chessBoard[r][c] == 'Q')
                return false;
            r--;
            c++;
        }
        
        return true;
    }
}