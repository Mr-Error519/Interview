package CodeTop.接雨水;

public class Solution {
    public int trap(int[] height) {
        boolean flag = false;
        int left = 0;
        int right = 0;
        int area = 0;
        int he = 0;

        for(int i = 0;i < height.length;++i){
            if(i > 0 && height[i] < height[i-1]){
                flag = true;
            }

            if(i > 0 && height[i] > height[i-1]){
                if(!flag){
                    left = i;
                }else{
                    int j = i;
                    right = j;
                    int max = height[j];
                    while(j < height.length){
                        right = height[j]>max?j:right;
                        if(height[j] >= height[left]) break;
                        ++j;
                    }
                    he = Math.min(height[left],height[right]);
                    area = area + he * (right - left);
                    while(left < right){
                        area = area - Math.min(height[left],he);
                        ++left;
                    }
                    flag = false;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4,2,0,3,2,5};
        Solution solution = new Solution();
        solution.trap(ints);
    }
}
