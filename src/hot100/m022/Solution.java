package hot100.m022;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
public class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("",0,0,n);

        return res;

    }

    public void dfs(String path,int left,int right,int n){
        if(left<right||left>n||right>n){
            return;
        }
        if(path.length()==2*n){
            res.add(path);
            return;
        }
        dfs(path+"(",left+1,right,n);
        dfs(path+")",left,right+1,n);
    }
}
