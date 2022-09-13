package hot100.m33;

//搜索旋转排序数组--二分排序
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = (left+right)/2;
            if(target==nums[mid]){
                return mid;
            }
            //左半部分为有序排列
            if(nums[0]<=nums[mid]){
                //nums[0]<=target<nums[mid] 往左找
                if(nums[left]<=target&&target<nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                //右半部分为有序排列
                //nums[mid]<target<=nums[right]
                if(nums[mid]<target&&target<=nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }

        }
        return -1;
    }
    public int binarySearch(int[] nums,int low,int hi,int target){
        while(low<hi){
            int mid=low+(hi-low)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(target<nums[mid]){
                hi=mid-1;
            }
            if(target>nums[mid]){
                low=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{3,1};
        solution.search(a,0);

    }
}
