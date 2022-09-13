package hot100.m055;

public class Solution {
    public boolean canJump(int[] nums) {
        return jump(nums,0);
    }

    public boolean jump(int[] nums,int pos){
        if(pos==nums.length-1){
            return true;
        }
        if(nums[pos]==0){
            return false;
        }
        for(int i=1;i<=nums[pos];++i){
            boolean flag = jump(nums,pos+i);
            if(flag){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{2,0};

        if(solution.canJump(ints)) System.out.println("true");

    }
}
