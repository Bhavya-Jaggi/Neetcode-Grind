class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] pacReach = new boolean[m][n];
        boolean[][] atlReach = new boolean[m][n];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(i == 0 || j== 0)
                {
                    pacQueue.add(new int[] {i , j});
                    pacReach[i][j] = true;
                }
                if(i == m - 1 || j == n - 1)
                {
                    atlQueue.add(new int[]{i , j});
                    atlReach[i][j] = true;
                }
            }
        }

        bfs(grid , pacQueue , pacReach);
        bfs(grid , atlQueue , atlReach);

        List<List<Integer>> res = new ArrayList<>();


        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0; j < grid[0].length ; j++)
            {
                if(pacReach[i][j] == true && atlReach[i][j] ==  true)
                {
                    List<Integer> temp = Arrays.asList(i , j); //No need to initialize as arrays first just comma enough
                    res.add(temp);
                }
            }
        }

        return res;
    }

    public void bfs(int[][] grid , Queue<int[]> oceanQueue , boolean[][] oceanReach)
    {
        int[][] directions = {{1 , 0} , {0 , 1} , {-1 , 0} , {0 , -1}};

        while(!oceanQueue.isEmpty())
        {
            int[] curr = oceanQueue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] dir : directions)
            {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if(newR < 0 || newC < 0 || newR >= grid.length || newC >= grid[0].length)
                    continue;
                if(oceanReach[newR][newC] == true)
                    continue;
                if(grid[newR][newC] < grid[r][c])
                    continue;
                else
                {
                    oceanReach[newR][newC] = true;
                    oceanQueue.add(new int[]{newR , newC});
                }

            }
        }


    }
}