package hot100.搜索旋转排序数组;

public class Solution {
    public int search(int[] nums, int target) {
        int index = 0;
        if(nums.length==0) return -1;
        if(nums.length==1){
            if(nums[0]==target){
                return 0;
            }else{
                return -1;
            }
        }
        for(int i = 0;i < nums.length;++i){
            if(i>0 && nums[i] < nums[i-1]){
                index = i-1;
                break;
            }
            index = i;
        }
        if(target>=nums[0]||index==nums.length-1){
            return binarySearch(nums,0,index,target);
        }else{
            return binarySearch(nums,index+1,nums.length-1,target);
        }
    }
    public int binarySearch(int[] nums,int start,int end,int target){
        int left = start,right = end;
        while(left<right){
            int mid = (left+right)>>1;
            if(nums[mid] == target) return mid;
            if(nums[mid]>target){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return nums[left]==target?left:-1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.search(new int[]{3,1},1);
    }
}
