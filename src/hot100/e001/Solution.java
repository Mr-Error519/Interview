package hot100.e001;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
//
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现
public class Solution {
    //超时
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            int j=dfs(nums,i+1,nums[i],target);
            if(j<nums.length){
                result[0]=i;
                result[1]=j;
                return result;
            }
        }
        return null;
    }
    public int dfs(int[] nums,int start, int sum, int target){
        if((sum+nums[start])==target){
            return start;
        }
        if(start<nums.length-1){
            int j = dfs(nums,start+1,sum,target);
            if(j<nums.length){
                return j;
            }
        }
        return nums.length;
    }
    //

    //
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] ints = new int[]{3,2,3};
        Solution solution = new Solution();
        for (int i : solution.twoSum(ints, 6)) {
            System.out.println(i);
        }


    }
}
