package mianshijingdian.tree.m0408;

import mianshijingdian.TreeNode;

//设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
public class Solution {
    TreeNode ancestorNode = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if((isHaveProject(root.left,p)||isHaveProject(root.left,q))&&(isHaveProject(root.right,q)||isHaveProject(root.right,p))||(root==p&&(isHaveProject(root.left,q)||isHaveProject(root.right,q)))||((root==q&&(isHaveProject(root.left,p)||isHaveProject(root.right,p))))){
            ancestorNode = root;
            return ancestorNode;
        }
        if(lowestCommonAncestor(root.left,p,q)!=null){
            return ancestorNode;
        }

        if(lowestCommonAncestor(root.right,p,q)!=null){
            return ancestorNode;
        };




        return ancestorNode;
    }

    public boolean isHaveProject(TreeNode root,TreeNode p1){
        if (root==null){
            return false;
        }
        if(isHaveProject(root.left,p1)){
            return true;
        }
        if(root==p1){
            return true;
        }
        if(isHaveProject(root.right,p1)){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(5);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        Solution solution = new Solution();
        System.out.println(solution.lowestCommonAncestor(treeNode,treeNode1,treeNode2).val);

    }
}
