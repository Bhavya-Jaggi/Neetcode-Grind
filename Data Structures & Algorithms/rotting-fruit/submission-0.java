//Did it myself hehe
class Solution 
{
    public int orangesRotting(int[][] grid) 
    {

        Queue<int[]> position = new LinkedList<>();

        for(int i = 0 ; i < grid.length ; i++) //Scanning for all rotten once putting them beforehand
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == 2)
                    position.add(new int[] {i,j});
            }
        }
        int time = bfs(grid , position);
        return time;
    }

    public int bfs(int[][] grid , Queue<int[]> pos)
    {
        int[][] directions = {{1,0} , {0 , -1} , {-1 , 0} , {0 , 1}};//Standard directions array
        int time = 0;

        while(true)
        {
            int len = pos.size(); //We need to run it level-wise so we need to calc lvl then go forward
            
            if(len == 0)//ASA u get len == 0 break the uppermost while(true) loop
                break;

            while(len-- > 0)//If i write "!queue.isEmpty()" it would ruin the level logic 
            {
                int[] curr = pos.poll();

                int r = curr[0]; //Unpacking the queue
                int c = curr[1];

                for(int[] dir : directions)//Loop to check all 4 dir of one single node at particular lvl
                {
                    int newR = r + dir[0];//Adjusting all 4 dir
                    int newC = c + dir[1];

                    //Boundary conditions
                    if(newR >= grid.length || newR < 0 || newC < 0 || newC >= grid[0].length)
                        continue;
                    if(grid[newR][newC] == 0)
                        continue;
                    if(grid[newR][newC] == 1)
                    {
                        grid[newR][newC] = 2;
                        pos.add(new int[] {newR , newC});
                    }
                }
            }
            if(!pos.isEmpty()) //Very crucial update time only when u find newly infected not otherwise
                time++;
        }

        for(int i = 0 ; i < grid.length ; i++) //Scanner to check for atleast single 'one'(fresh)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == 1)
                {
                    return -1;//Return directly don't break
                }
            }
        }
        return time; //If all are rotten then return calculated time
    }
}