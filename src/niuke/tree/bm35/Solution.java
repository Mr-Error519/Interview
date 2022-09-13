package niuke.tree.bm35;

import mianshijingdian.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if(root==null) return true;
        Deque<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;++i){
                root = queue.poll();
                if(root!=null&&flag) return false;
                if(root==null){
                    flag = true;
                }else{
                    queue.offer(root.left);
                    queue.offer(root.right);
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;

        Solution solution = new Solution();
        solution.isCompleteTree(treeNode);
    }
}
