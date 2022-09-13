package mianshijingdian.m0809;

import java.util.ArrayList;
import java.util.List;

//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
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














//        dfs("",0,0,n);
//        return res;
//
//    }
//    private void dfs(String paths,int left,int right,int n){
//        if(left>n || right>left) return;
//        if(paths.length()==2*n){
//            res.add(new String(paths));
//            return ;
//        }
//        dfs(paths+"(",left+1,right,n);
//        dfs(paths+")",left,right+1,n);

}
