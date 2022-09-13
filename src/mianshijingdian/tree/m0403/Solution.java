package mianshijingdian.tree.m0403;

import mianshijingdian.ListNode;
import mianshijingdian.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
public class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        //广度优先遍历二叉树
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<ListNode> listNodes = new ArrayList<>();
        //树为空
        if (tree==null){
            return null;
        }
        queue.add(tree);
        while (!queue.isEmpty()){
            int size = queue.size();
            ListNode listNode = null;
            for (int i = 0; i <size ; i++) {
                TreeNode tmp = queue.remove();
                 //每一层的头结点加入链表
                if(i==0){
                    listNode = new ListNode(tmp.val);
                    listNodes.add(listNode);
                 }else {
                     listNode.next = new ListNode(tmp.val);
                     listNode = listNode.next;
                 }
                if(tmp.left!=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }

            }

        }
        ListNode[] listNodes1 =listNodes.toArray(new ListNode[] {});
        return listNodes1;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(8);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = null;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        for (ListNode listNode : solution.listOfDepth(root)) {
            while (listNode!=null){
                System.out.println(listNode.val);
                listNode = listNode.next;
            }
        }
    }
}



