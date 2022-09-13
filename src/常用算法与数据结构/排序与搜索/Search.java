package 常用算法与数据结构.排序与搜索;

public class Search {
    public int bin_search(int nums[],int target){

        if(nums.length==0) return -1;
        int l = 0;
        int r = nums.length-1;

        while(l<r){
            int mid = (l+r)>>1;
            if(nums[mid]>=target){
                r = mid;
            }else{
                l = mid+1;
            }
        }

        return nums[l]==target ? l:-1;
    }
}
