package hot100.h084;

import java.util.Arrays;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] arr = new int[heights.length];
        int min = -1;
        int max = -1;
        for(int i=heights.length-1;i>0;--i){
            max = heights[i];
            for(int j=0;j<i;++j){
                min = heights[i];
                for(int k=j;k<i;++k){
                    if(heights[k]<min) min = heights[k];
                }
                if(min*(i-j+1)>max) max = min*(i-j+1);
            }
            arr[i] = max;
        }
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{2,1,5,6,2,3};
        solution.largestRectangleArea(ints);

    }
}
