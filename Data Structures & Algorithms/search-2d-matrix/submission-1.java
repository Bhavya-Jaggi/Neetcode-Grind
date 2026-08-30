class Solution {
    public boolean searchMatrix(int[][] grid, int x) {

        int m = grid.length;
        int n = grid[0].length;

        int left = 0;
        int right = m * n - 1;

        while(left <= right)
        {
            int mid = left + right;
            mid /= 2;

            int row = mid / n;          //Row = mid / number of cols
            int col = mid % n;          //Col = mid % number of Cols 

            if(grid[row][col] == x)
                return true;
            else if(grid[row][col] < x)
            {
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return false;
    }
}