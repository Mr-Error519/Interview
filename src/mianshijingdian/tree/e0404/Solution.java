package mianshijingdian.tree.e0404;

import mianshijingdian.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
public class Solution {
    public boolean isBalanced(TreeNode root) {
            //后序遍历二叉树将每一个结点加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        postOrder(queue,root);
        TreeNode treeNode;
        while ((treeNode=queue.poll())!=null){
            System.out.println(heightCompute(treeNode.left));
            System.out.println(heightCompute(treeNode.right));

            if((heightCompute(treeNode.left)-heightCompute(treeNode.right))>1||(heightCompute(treeNode.left)-heightCompute(treeNode.right)<-1)){
                return false;
            }
        }
        return true;
    }
   //计算二叉树高度
    public int heightCompute(TreeNode root){
        int hleft = 0;
        int hright = 0;
        if(root==null){
            return 0;
        }else {
            hleft =heightCompute(root.left);
            hright = heightCompute(root.right);
    }
        if(hleft>hright){
            return hleft+1;
        }else {
            return  hright+1;
        }
}
    //后序遍历二叉树
    public void postOrder(Queue<TreeNode> queue,TreeNode root){
        if(root==null){
            return;
        }
        postOrder(queue,root.left);
        postOrder(queue,root.right);
        queue.add(root);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left=null;
        node1.right = node2;
        node2.left = null;
        node2.right = node3;

        if(solution.isBalanced(node1)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
}

