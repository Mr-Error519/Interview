package mianshijingdian.e0810;

//编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
//待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的行坐标为 sr 列坐标为 sc。需要填充的新颜色为 newColor 。
//「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
//请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //DFS
        dfs(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    public void dfs(int[][] image,int row,int col,int newColor,int prime){

        if(row<0||col<0||row>=image.length||col>=image[0].length){
            return;
        }


        if(image[row][col]==prime){
            image[row][col]=newColor;
            dfs(image,row+1,col,newColor,prime);
            dfs(image,row-1,col,newColor,prime);
            dfs(image,row,col+1,newColor,prime);
            dfs(image,row,col-1,newColor,prime);
        }

    }

    public static void main(String[] args) {
        int[][] image=new int[][]{{0,0,0},{0,1,1}};
        Solution solution = new Solution();
        solution.floodFill(image,1,1,1);

    }
}
