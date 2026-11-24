
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        long minAbsVal = matrix[0][0];
        int m = matrix.length;
        int n = matrix[0].length;
        int negCount = 0;
        long sum = 0;
        int minNum = Math.abs(matrix[0][0]); 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] < 0) negCount++;
                sum += Math.abs(matrix[i][j]);
                minNum = Math.min(minNum, Math.abs(matrix[i][j]));               
                
            }
        }

        if(negCount % 2 == 0) return sum;
        return sum - (2 * minNum);
        
    }
}