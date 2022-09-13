package niuke.查找.bm18;

public class Solution {
    public boolean Find(int target, int [][] array) {

        int down = 0;
        if(array[0].length==0) return false;
        if(array[0][0]>target) return false;
        int left = array[0].length-1;

        while(left>0&&down<array.length){
            if(array[down][left]==target) return true;
            if(array[down][left]>target){
                --left;
            }else{
                ++down;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] i = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Solution solution = new Solution();
        solution.Find(1,i);
    }
}
