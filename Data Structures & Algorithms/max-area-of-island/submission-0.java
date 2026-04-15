class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea = 0;
        int currArea = 0;

        for(int i = 0 ; i < grid.length ; i++) //Scan the the whole grid
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == 1)
                {
                    grid[i][j] = 0;
                    currArea = bfs(grid , i , j);
                    maxArea = currArea >= maxArea ? currArea : maxArea;
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid , int x , int y)
    {
        int currArea = 1; //Initialize the area to 1 cuz u already came here after finding an island 
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while(!queue.isEmpty())
        {
            int[] current = queue.poll();

            int a = current[0];
            int b = current[1];

            if(a - 1 >= 0 && grid[a - 1][b] == 1) //Boundary cond plus UP check
            {
                grid[a-1][b] = 0;
                currArea++;
                queue.add(new int[]{a-1 , b});
            }
            if(b - 1 >= 0 && grid[a][b - 1] == 1) //Boundary condn plus LEFT
            {
                grid[a][b-1] = 0;
                currArea++;
                queue.add(new int[]{a , b - 1});
            }
            if(a + 1 < grid.length && grid[a + 1][b] == 1) //Downn
            {
                grid[a + 1][b] = 0;
                currArea++;
                queue.add(new int[]{a + 1 , b});
            }
            if(b + 1 < grid[0].length && grid[a][b + 1] == 1) //Right
            {
                grid[a][b + 1] = 0;
                currArea++;
                queue.add(new int[]{a , b+1});
            } 
        }
        return currArea;
    }
}
