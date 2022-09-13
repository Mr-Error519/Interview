package 每日一题.矩阵对角线排序;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for(int b = -(n - 1); b < m ;++b){
            List<Integer> list = new ArrayList<>();
            for(int x = 0, y = b; x < n && y < m; ++x, ++y){
                if(y >= 0){
                    list.add(mat[y][x]);
                }
            }
            list.sort(null);
            int i = 0;
            for(int x = 0, y = b; x < n && y < m; ++x, ++y){
                if(y >= 0){
                    mat[y][x] = list.get(i);
                    ++i;
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{3,3,1,1}, {2,2,1,2}, {1,1,1,2}};
        Solution solution = new Solution();
        solution.diagonalSort(mat);

    }
}
