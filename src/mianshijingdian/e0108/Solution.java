package mianshijingdian.e0108;

//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if(matrix[i][j]==0){
                    row.add(i);
                    column.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if(row.contains(i)||column.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes(ints);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.println(ints[i][j]);
            }
        }
    }
}
