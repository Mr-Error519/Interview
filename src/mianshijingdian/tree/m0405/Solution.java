package mianshijingdian.tree.m0405;

import mianshijingdian.TreeNode;

import java.util.Stack;

//实现一个函数，检查一棵二叉树是否为二叉搜索树。
public class Solution {
    public boolean flag = true;
    public int prev = Integer.MIN_VALUE;
    TreeNode prevnode;
    public boolean isValidBST(TreeNode root) {
    if(root==null){
        return true;
    }
    if(root.left==null&&root.right==null){
            return true;
        }
    if(flag){

        isValidBST(root.left);
    }
    if(root.val<=prev){
        flag = false;

    }
    prev = root.val;
    if (flag){
        isValidBST(root.right);

    }
        return flag;
    }
    public boolean isValidBST1(TreeNode root) {
        if(root==null){
            return true;
        }
        //如果左子树不是二叉搜索树直接return
        if(!isValidBST(root.left)){
            return false;
        }
        if(prevnode!=null&&root.val<=prevnode.val){
            return false;
        }
        prevnode = root;
        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }
    //中序遍历非递归
    public boolean isValidBST2(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();

        //
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                //一直走到左子树最后一个左孩子结点
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prevnode!=null&&prevnode.val>=root.val){
                return false;
            }
            prevnode = root;
            root = root.right;
        }
        return true;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode.left = treeNode1;
        treeNode.right = null;
        Solution solution = new Solution();

        if(solution.isValidBST(treeNode)){
            System.out.println(true);
        }


    }
}
