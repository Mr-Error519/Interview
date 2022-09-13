package CodeTop.K个最大元素;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, 0, nums.length-1, k);
    }
    public int partition(int[] nums, int start, int end, int k){
        int left = start;
        int right = end;
        int key = nums[left];
        while(left < right){
            while(left < right && nums[right] >= key){
                --right;
            }
            nums[left] = nums[right];
            while(right > left && nums[left] <= key){
                ++left;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        if(left == k){
            return nums[left];
        }else if(left < k){
            return partition(nums, left, end, k);
        }else{
            return partition(nums, 0, left, k);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,1,5,6,4};
        solution.findKthLargest(nums, 2);
    }
}
