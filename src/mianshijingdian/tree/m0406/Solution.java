package mianshijingdian.tree.m0406;

import mianshijingdian.TreeNode;

import java.util.Stack;

//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
//
//如果指定节点没有对应的“下一个”节点，则返回null。
public class Solution {
    public TreeNode projectNode=null;
    public TreeNode prev;
//    public mianshijingdian.TreeNode inorderSuccessor(mianshijingdian.TreeNode root, mianshijingdian.TreeNode p) {
//        if(root==null){
//            return null;
//        }
//        if(root.left!=null){
//            if(inorderSuccessor(root.left,p)!=null){
//                return projectNode;
//            }
//        }
//        if(prev==p){
//            projectNode=root;
//            return projectNode;
//        }
//        prev = root;
//        if(root.right!=null){
//            if(inorderSuccessor(root.right,p)!=null){
//                return projectNode;
//            }
//        }
//        return projectNode;
//    }
    //非递归中序遍历
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {


        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev!=null&&prev==p){
                return root;
            }
            prev = root;
            root = root.right;
        }
        return null;


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        System.out.println(solution.inorderSuccessor1(treeNode,treeNode1).val);
    }
}
