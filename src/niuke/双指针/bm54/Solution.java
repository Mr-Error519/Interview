package niuke.双指针.bm54;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int left = 0;
        int right = num.length-1;
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        if(num.length<3) return res;

        for(int i=0;i<num.length;++i){
            if(i>0&&num[i]==num[i-1]) continue;
            if(num[i]>0) break;
            left = i+1;
            right = num.length-1;


            while(left<num.length&&left<right){
                int sum = num[i]+num[left]+num[right];
                if(sum==0){
                    path.add(num[i]);
                    path.add(num[left]);
                    path.add(num[right]);
                    res.add(new ArrayList<>(path));
                    path.clear();
                    while(left<right&&num[left+1]==num[left]){
                        ++left;
                    }
                    while(left<right&&num[right-1]==num[right]){
                        --right;
                    }
                    ++left;
                    --right;
                }
                if(sum<0){
                    ++left;
                }
                if(sum>0){
                    --right;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        Solution solution = new Solution();
        solution.threeSum(ints);
    }
}
