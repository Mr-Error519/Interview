package hot100.m015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        int left=0;
        int right=0;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-2 ; i++) {
            if(nums[i]>0){
                break;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            left=i+1;
            right=nums.length-1;
            while(left<right){
                if((nums[i]+nums[left]+nums[right])<0){
                    while(left<nums.length-1&&nums[left+1]==nums[left]){
                        ++left;
                    }
                    ++left;
                    continue;
                }
                if((nums[i]+nums[left]+nums[right])>0){
                    while(right>0&&nums[right-1]==nums[right]){
                        --right;
                    }
                    --right;
                    continue;
                }
                if((nums[i]+nums[left]+nums[right])==0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while(left<nums.length-1&&nums[left+1]==nums[left]){
                        ++left;
                    }
                    ++left;
                    while(right>0&&nums[right-1]==nums[right]){
                        --right;
                    }
                    --right;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{-2,0,0,2,2};
        solution.threeSum(ints);

    }
}
