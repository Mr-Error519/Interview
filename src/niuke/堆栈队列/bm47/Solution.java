package niuke.堆栈队列.bm47;

public class Solution {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return quickSort(a,K,0,a.length-1);
    }

    public int quickSort(int[] a,int k,int start,int end){
        int left = start+1;
        int right = end;
        while(left<right){
            while(left<right&&a[right]>=a[start]) --right;
            while(left<right&&a[left]<=a[start]) ++left;
            swap(a,left,right);
        }
        swap(a,left,start);
        if(left==a.length-k) return a[left];
        if(left<a.length-k){
            return quickSort(a,k,left+1,end);
        }else{
            return quickSort(a,k,start,left);
        }
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,2,2};
        Solution solution = new Solution();
        solution.findKth(nums,5,3);

    }

    
}
