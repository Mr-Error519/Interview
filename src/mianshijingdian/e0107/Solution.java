package mianshijingdian.e0107;

//给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
public class Solution {
    public void rotate(int[][] matrix) {
        int[][] ints = new int[matrix.length][matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length ; j++) {
                ints[i][j] = matrix[matrix.length-j-1][i];
            }
        }
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length ; j++) {
                matrix[i][j] = ints[i][j];
            }
        }
    }

    public void rotate1(int[][] matrix) {

    }
}
