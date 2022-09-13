package hot100.m078;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums,0,res,path);

        return res;
    }

    public void dfs(int[] nums,int index,List<List<Integer>> res,Deque<Integer> path){
        res.add(new ArrayList<Integer>(path));
        for(int i=index;i<nums.length;++i){
            path.addLast(nums[i]);
            dfs(nums,i+1,res,path);
            path.removeLast();
        }
        return;
    }
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3};
        Solution solution = new Solution();
        solution.subsets(ints);

    }
}
