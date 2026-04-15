class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length , n = matrix[0].length;

        int start = 0,end = m - 1;

        int left = 0,right = n-1 ,medRow,medCol;

        while(start <= end)
        {
            medRow = (start + end) / 2;

            if(target >= matrix[medRow][0] && target <= matrix[medRow][n-1])
            {
                while(left <= right)
                {
                    medCol = (left + right) / 2;
                    if(target == matrix[medRow][medCol])
                        return true;
                    else if(target < matrix[medRow][medCol])
                        right = medCol - 1;
                    else if(target > matrix[medRow][medCol])
                        left = medCol + 1;
                }
                return false;
            }
            else if(target > matrix[medRow][n-1])
                start = medRow + 1;
            else if(target < matrix[medRow][0])
                end = medRow - 1;
        }
        return false;
    }
}