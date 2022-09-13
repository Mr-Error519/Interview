package hot100.m039;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<List<Integer>> result = new ArrayList<>();
    static ArrayList<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {


            dfs(target,candidates,0,0);

        return result;
    }

    public void dfs(int target,int[] nums,int index,int startindex){
        if(sum(path)==target){
            List<Integer> copy = copy(path);
            result.add(copy);
            return;
        }


        if(sum(path)>target){
            return;
        }

        for(int i=startindex;i<nums.length;++i){
            path.add(nums[i]);
            dfs(target,nums,index+1,i);
            path.remove(index);
        }
    }
    public int sum(List<Integer> nums){
        int sum=0;
        for(Integer num : nums){
            sum+=num;
        }
        return sum;
    }

    public List<Integer> copy(List<Integer> list){
        List<Integer> copylist = new ArrayList<>();
        for(Integer integer : list){
            copylist.add(integer);
        }
        return copylist;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] ints = new int[]{2,3,5,9,13,14};
        List<List<Integer>> lists = solution.combinationSum(ints,27);
    }
}
