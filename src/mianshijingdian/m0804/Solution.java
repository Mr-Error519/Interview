package mianshijingdian.m0804;

import java.util.ArrayList;
import java.util.List;

//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        ArrayList<Integer> sonlist = new ArrayList<>();
        sonlist.add(nums[0]);
        list.add(sonlist);
        int k = 1;
        for (int i = 1; i <nums.length ; i++) {
            int j = list.size();
            int m = 0;
            //使用副本合并
            while(j>0){
                int a =0;
                List<Integer> list1 = new ArrayList<>();
                while(a<list.get(m).size()){
                    list1.add(list.get(m).get(a));
                    a++;
                }
                list.add(list1);

                list.get(m).add(nums[i]);
                m++;
                k++;
                j--;
            }
            //新建一个nums[i]集合
            List<Integer> newlist = new ArrayList<>();
            newlist.add(nums[i]);
            list.add(newlist);
            k++;
        }
        List<Integer> nulllist = new ArrayList<>();
        nulllist.add(null);
        list.add(nulllist);
        return list;


    }
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(1 << nums.length);
        //先添加一个空的集合
        res.add(new ArrayList<>());
        for (int num : nums) {
            //每遍历一个元素就在之前子集中的每个集合追加这个元素，让他变成新的子集
            for (int i = 0, j = res.size(); i < j; i++) {
                //遍历之前的子集，重新封装成一个新的子集
                List<Integer> list = new ArrayList<>(res.get(i));
                //然后在新的子集后面追加这个元素
                list.add(num);
                //把这个新的子集添加到集合中
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.subsets(new int[]{1,2,3});

    }
}
