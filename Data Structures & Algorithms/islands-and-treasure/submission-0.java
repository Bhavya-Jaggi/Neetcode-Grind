class Solution {
    
    public static final int inf = Integer.MAX_VALUE;

    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < m ; i++)//First we find and add all the '0's to queue
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(grid[i][j] == 0)
                {
                    queue.add(new int[]{i , j});
                }
            }
        }
        bfs(grid , queue);
    }

    public void bfs(int[][] grid , Queue<int[]> queue)
    {
        int[][] directions = {{1,0} , {-1,0} , {0,1} , {0,-1}};//Simple way to check all four directions

        while(!queue.isEmpty())
        {
            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for(int[] dir : directions)
            {
                int newR = r + dir[0];
                int newC = c + dir[1];
                
                //Out of bounds so ignore
                if(newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length)
                    continue;
                if(grid[newR][newC] == -1)//Wall ignore
                    continue;
                if(grid[newR][newC] == inf) //Can't put 'else' here or infinite loop
                {
                    grid[newR][newC] = grid[r][c] + 1;//Logic to add 1 without maintaining math
                    queue.add(new int[]{newR , newC});//AddOnly the INF cell back to the queue
                }

            }
        }
    }
}
