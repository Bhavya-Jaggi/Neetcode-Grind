// DFS Solution
class Solution {
    public int numIslands(char[][] grid) {
        

        int island = 0;

        //O(M+N) which is the size of matrix?
        for(int i = 0 ; i < grid.length ; i++) //Scanner loops
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == '1')
                {
                    island++;
                    // grid[i][j] = '0'; You cannot declare it 0 here let DFS do the job
                    dfs(grid , i, j);
                }
            }
        }
        return island;
    }

    public void dfs(char[][] grid , int x , int y) //U always need a helper method be it DFS or BFS
    {
        //Boundary condition and already '0' check
        if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == '0')
            return;
        
        grid[x][y] = '0'; //Since it passed above if condition it's guaranteed to '1' so flip it to '0'

        dfs(grid , x + 1 , y); //Down check
        dfs(grid , x , y - 1); //Left check
        dfs(grid , x - 1 , y); //Up check
        dfs(grid , x , y + 1); //Right check
    }
}