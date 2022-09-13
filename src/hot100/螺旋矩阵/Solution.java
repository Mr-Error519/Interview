package hot100.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //flag=0右 flag=1下 flag=2左 flag=3上
        List<Integer> res = new ArrayList<>();
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
        dfs(matrix,0,0,visit,res,0);
        return res;
    }
    public void dfs(int[][] matrix, int i, int j, boolean[][] visit, List<Integer> res, int flag){
        if(res.size()==matrix.length*matrix[0].length) return;
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||visit[i][j]) return;
        visit[i][j] = true;
        res.add(matrix[i][j]);
        if(flag==0){
            dfs(matrix,i,++j,visit,res,0);
            dfs(matrix,++i,j,visit,res,1);
        }
        else if(flag==1){
            dfs(matrix,++i,j,visit,res,1);
            dfs(matrix,i,--j,visit,res,2);
        }
        else if(flag==2){
            dfs(matrix,i,--j,visit,res,2);
            dfs(matrix,--i,j,visit,res,3);
        }
        else if(flag==3){
            dfs(matrix,--i,j,visit,res,3);
            dfs(matrix,i,++j,visit,res,0);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.spiralOrder(new int[][]{{3},{2}});
    }
}
