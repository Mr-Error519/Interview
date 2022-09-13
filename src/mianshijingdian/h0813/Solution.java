package mianshijingdian.h0813;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
//
//输入使用数组[wi, di, hi]表示每个箱子。
public class Solution {
     ArrayList<Integer> h=new ArrayList<>();
     ArrayList<Integer> res=new ArrayList<>();
    public int pileBox(int[][] box) {

        for (int i = 0; i <box.length ; i++) {
            dfs(0,0,i,box.length,0,box);
        }
        h.sort(Comparator.reverseOrder());
        return h.get(0);
    }
    public void dfs(int flag,int prev,int start,int len,int height,int[][] box){

        if(flag>0){
            if(box[prev][0]<=box[start][0]||box[prev][1]<=box[start][1]||box[prev][2]<=box[start][2]){
                return;
            }
        }
        res.add(start);
        height+=box[start][2];
        for (int i = 0; i <len ; i++) {
            if(res.contains(i)){
                continue;
            }
            dfs(flag+1,start,i,len,height,box);
        }
        h.add(height);
        Integer integer = start;
        res.remove(integer);
    }
    public int pileBox1(int[][] box) {
        int len = box.length;
        if(len == 0)
            return 0;
        //排序
        Arrays.sort(box, (o1, o2) -> o1[0] - o2[0]);
        int[] dp = new int[len];
        //初始化,第一个箱子的高度
        dp[0] = box[0][2];
        int res = box[0][2];
        //第二个箱子开始
        for(int i = 1; i < len; i++) {
            //求dp[ 0 1 2 ... i - 1]中最大的那个
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(box[j][0] < box[i][0] && box[j][1] < box[i][1] && box[j][2] < box[i][2])
                    max = Math.max(max, dp[j]);
            }
            dp[i] = max + box[i][2];
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] box = new int[][]{{1,1,1},{2,3,4},{2,6,7},{3,4,5}};
        Solution solution = new Solution();
        solution.pileBox(box);
    }
}
