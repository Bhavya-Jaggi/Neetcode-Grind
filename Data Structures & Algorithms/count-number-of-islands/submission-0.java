class Solution {
    public int numIslands(char[][] grid) {

        char[][] upGrid = new char[grid.length + 2][grid[0].length + 2]; //For padding we need to enclose it it
        // boundary for that u need to do a +2 not +1
        int island = 0;

        for(int i = 1 ; i < upGrid.length - 1 ; i++)
        {
            for(int j = 1 ; j < upGrid[0].length - 1 ; j++)
            {
                upGrid[i][j] = grid[i - 1][j - 1]; //Note this cuz u need to extract the grid[0][0] so u -1
            }
        }

        for(int i = 1 ; i < upGrid.length - 1; i++)
        {
            for(int j = 1 ; j < upGrid[0].length - 1 ; j++)
            {
                char ch = upGrid[i][j];
                if(ch == '1')
                {
                    island++;
                    upGrid[i][j] = '0';
                    bfs(upGrid , i , j); 
                }
            }
        }
        return island;
    }

    public void bfs(char[][] upGrid , int a , int b)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a , b});

        while(!queue.isEmpty())
        {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            // UpCheck
            if(upGrid[x - 1][y] == '1')
            {
                upGrid[x - 1][y] = '0';
                queue.add(new int[]{ x - 1 , y});
            }
            //rightCheck
            if(upGrid[x][ y + 1] == '1')
            {
                upGrid[x][y + 1] = '0';
                queue.add(new int[]{x, y+1});
            }
            //Bottom Check
            if(upGrid[x + 1][y] == '1')
            {
                upGrid[x + 1][y] = '0';
                queue.add(new int[]{x+1 , y});
            }
            //Left Check
            if(upGrid[x][y-1] == '1')
            {
                upGrid[x][y-1] = '0';
                queue.add(new int[]{x, y-1});
            }
        }
        return;
    }
}