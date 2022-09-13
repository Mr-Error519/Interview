class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,k);
    }

    public int quickSort(int[] nums,int left,int right,int k){
        int key = nums[left];
        int start = left;
        int end = right;
        while(left<right){
            while(left<right&&nums[right]<=key){
                --right;
            }
            nums[left] = nums[right];
            while(left<right&&nums[left]>=key){
                ++left;
            }
            nums[right] = nums[left];
        }
        nums[left] = key;
        if(left==k) return nums[left];
        if(left>k){
            return quickSort(nums,start,left,k);
        }else{
            return quickSort(nums,left+1,end,k);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findKthLargest(new int[]{3,2,1,5,6,4},2);
    }
}

