package 常用算法与数据结构.数据结构;

import mianshijingdian.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Tree {
    //前序-迭代
    public void pre_order(TreeNode root){
        if(root==null) return;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            System.out.println(root.val);

            //右节点后访问先入栈
            if(root.right!=null) stack.push(root.right);
            if(root.left!=null) stack.push(root.left);
        }

    }

    //中序-迭代
    public int[] mid_order(TreeNode root){
        if(root==null) return new int[0];

        ArrayList<Integer> integers = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            integers.add(root.val);
            root =root.right;

        }

        return integers.stream().mapToInt(Integer::valueOf).toArray();

    }

    //后序-迭代
    public void post_order(TreeNode root){
        if(root==null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;

        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            //1.root.right为null直接读取当前节点值
            //2.root.right读取过也直接读取当前节点
            if(root.right!=null&&root.right!=pre){
                //当前节点还不能读取，继续入栈
                stack.push(root);
                root = root.right;
            }else {
                //
                System.out.println(root.val);
                pre = root;
                root = null;
            }
        }
    }

    //层次
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0;i<n;++i){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            res.add(list);
        }

        return res;
    }
}
