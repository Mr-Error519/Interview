package niuke.回溯.bm55;

import java.util.ArrayList;

public class Solution {

        public ArrayList<ArrayList<Integer>> permute(int[] num) {
            ArrayList<Integer> path = new ArrayList<>();
            ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
            dfs(res,path,num,0);
            return res;
        }

        public void dfs(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> path,int[] num,int start){
            if(path.size()==num.length) res.add(new ArrayList<>(path));
            for(int i=0;i<num.length;++i){
                if(path.contains(num[i])){
                    continue;
                }
                path.add(num[i]);

                dfs(res,path,num,start+1);
                path.remove(start);

            }
            return;
        }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3};
        Solution solution = new Solution();
        solution.permute(ints);
    }
}
