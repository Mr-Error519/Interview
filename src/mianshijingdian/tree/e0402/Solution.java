package mianshijingdian.tree.e0402;


//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
public class Solution {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public static TreeNode sortedArrayToBST(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        int id = (start+end)>>1;
        TreeNode treeNode = new TreeNode(nums[id]);
        treeNode.left = sortedArrayToBST(nums,start,id-1);
        treeNode.right = sortedArrayToBST(nums,id+1,end);
        return treeNode;
    }
//    public mianshijingdian.TreeNode sortedArrayToBST(int[] num) {
//        if (num.length == 0)
//            return null;
//        return sortedArrayToBST(num, 0, num.length - 1);
//    }
//
//    public mianshijingdian.TreeNode sortedArrayToBST(int[] num, int start, int end) {
//        if (start > end)
//            return null;
//        int mid = (start + end) >> 1;
//        mianshijingdian.TreeNode root = new mianshijingdian.TreeNode(num[mid]);
//        root.left = sortedArrayToBST(num, start, mid - 1);
//        root.right = sortedArrayToBST(num, mid + 1, end);
//        return root;
    public static void main(String[] args) {

        int[] nums ={-10,-3,0,5,9};
        sortedArrayToBST(nums);
        for (int num : nums) {
            System.out.println(num);
        }


}




}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }