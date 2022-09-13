package hot100.m011;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
//找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

public class Solution {
    public int maxArea(int[] height) {
        int max=0;
        int v=0;

        for (int i = 0; i <height.length ; i++) {

            for (int j = 0; j <i ; j++) {
                if(height[j]<=height[i]){
                    v=height[j]*(i-j);
                    if(v>max){
                        max=v;
                    }
                }else {
                    v=height[i]*(i-j);
                    if(v>max){
                        max=v;
                    }
                }

            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,8,6,2,5,4,8,3,7};
        Solution solution = new Solution();
        solution.maxArea(ints);

    }
}
