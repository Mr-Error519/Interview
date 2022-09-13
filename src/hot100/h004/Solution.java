package hot100.h004;

import java.util.ArrayList;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middle = 0;
        ArrayList<Integer> arr=new ArrayList<Integer>();
        int tar = (nums1.length+nums2.length)/2;
        int index1=0;
        int index2=0;
        arr.add(tar);
        int temp=0;

        if((nums1.length+nums2.length)%2==0){
            arr.add(tar-1);
        }

        for(int i=0;i<=tar;++i){

            if(index1<nums1.length){
                if(index2<nums2.length&&nums1[index1]<=nums2[index2]){
                    temp=nums1[index1];
                    ++index1;
                    if(arr.contains(i)){
                        middle+=temp;
                    }
                    continue;
                }else if(index2>=nums2.length) {
                    //index2越界
                    temp=nums1[index1];
                    ++index1;
                    if(arr.contains(i)){
                        middle+=temp;
                    }
                    continue;
                }
            }

            if(index2<nums2.length){
                if(index1<nums1.length&&nums1[index1]>=nums2[index2]){
                    temp=nums2[index2];
                    ++index2;
                    if(arr.contains(i)){
                        middle+=temp;
                    }
                    continue;
                }else if(index1>=nums1.length){
                    //index1越界
                    temp=nums2[index2];
                    ++index2;
                    if(arr.contains(i)){
                        middle+=temp;
                    }
                    continue;
                }
            }
        }
        float res = (float)middle/arr.size();
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        solution.findMedianSortedArrays(nums1,nums2);
    }
}
