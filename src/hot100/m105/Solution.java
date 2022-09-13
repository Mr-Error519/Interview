package hot100.m105;

import mianshijingdian.TreeNode;

import java.util.HashMap;

public class Solution {
    private HashMap<Integer,Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;++i){
            indexMap.put(inorder[i],i);
        }
        return build(preorder,inorder,0,preorder.length,0,inorder.length);
    }
    public TreeNode build(int[] preorder,int[] inorder,int p_start,int p_end,int i_start,int i_end){
        if(p_start==p_end) return null;
        TreeNode root = new TreeNode(preorder[p_start]);
        int root_index = indexMap.get(root.val);
        int leftnum = root_index-i_start;

        root.left = build(preorder,inorder,p_start+1,p_start+leftnum+1,i_start,root_index-1);
        root.right = build(preorder,inorder,p_start+leftnum+1,p_end,root_index+1,i_end);

        return root;


    }
}
