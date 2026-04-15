class NumMatrix {

    int[][] prefixMatrix;

    public NumMatrix(int[][] matrix) {
        int r = matrix.length + 1; //Increasing length to pad the array's first row and first column with 0's
        int c = matrix[0].length + 1;

        prefixMatrix = new int[r][c];

        for(int i = 1 ; i < r ; i++)
        {
            for(int j = 1 ; j < c ; j++)
            {
                prefixMatrix[i][j] = prefixMatrix[i-1][j] + prefixMatrix[i][j-1]
                 - prefixMatrix[i-1][j-1] + matrix[i-1][j-1];
            }
        }

        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        row1 += 1; //Since our prefixArray is padded therefore we pad values here too
        col1 += 1;
        row2 += 1;
        col2 += 1;

        int sum = prefixMatrix[row2][col2] - prefixMatrix[row1-1][col2]
         - prefixMatrix[row2][col1-1] + prefixMatrix[row1-1][col1-1];

         return sum;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */