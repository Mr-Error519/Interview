package niuke.dp.bm68;

public class Solution {
    public int minPathSum (int[][] matrix) {
        // write code here
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(i==0&&j==0) continue;
                if(i==0){
                    matrix[i][j] = matrix[i][j-1]+matrix[i][j];
                    continue;
                }
                if(j==0){
                    matrix[i][j] = matrix[i-1][j]+matrix[i][j];
                    continue;
                }
                matrix[i][j] = Math.min(matrix[i][j-1],matrix[i-1][j])+matrix[i][j];
            }
        }

        return matrix[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
        Solution solution = new Solution();
        solution.minPathSum(ints);
    }
}
