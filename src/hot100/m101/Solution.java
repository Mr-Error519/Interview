package hot100.m101;

import mianshijingdian.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> compare = new LinkedList<>();
        TreeNode prev = new TreeNode(0);
        TreeNode metaroot = root;
        boolean flag = false;
        while(root!=null||!stack.isEmpty()){
            if(prev==metaroot) flag=true;
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(flag){
                if(compare.isEmpty()||root.val!=compare.pop().val) return false;
            }else{
                compare.push(root);
            }
            prev = root;
            root = root.right;
        }
        if(!compare.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        Solution solution = new Solution();
        solution.isSymmetric(root);

    }
}
