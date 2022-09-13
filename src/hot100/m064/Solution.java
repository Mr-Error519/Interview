package hot100.m064;

public class Solution {
    public int minPathSum(int[][] grid) {

        for(int i=0;i<grid.length;++i){
            for(int j=0;j<grid[0].length;++j){
                if(i==0&&j==0) continue;
                if(i==0){
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                    continue;
                }
                if(j==0){
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                    continue;
                }
                grid[i][j]=Math.min(grid[i-1][j]+grid[i][j],grid[i][j-1]+grid[i][j]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        solution.minPathSum(new int[][]{{1,2,3},{4,5,6}});
    }
}
