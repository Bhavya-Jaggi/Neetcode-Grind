// DFS Implementation!
class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        int currArea = 0;

        for(int i = 0 ; i < grid.length ; i++) //Scanning through the entire grid
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == 1)
                {
                    currArea = dfs(grid , i , j);
                    maxArea = Math.max(currArea , maxArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid , int x , int y)
    {
        //Boundary and water check
        if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == 0)
            return 0;


        grid[x][y] = 0; //Sink the current island

        int currSum = 1; //Since it passed 'if' it is guaranteed to be 1

        //All directions return their respective areas and we add them all 
        currSum += dfs(grid , x + 1 , y);
        currSum += dfs(grid , x - 1 , y);
        currSum += dfs(grid , x , y + 1);
        currSum += dfs(grid , x , y - 1);

        return currSum;
    }
}