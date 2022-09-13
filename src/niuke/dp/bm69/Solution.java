package niuke.dp.bm69;

public class Solution {
    public int solve (String nums) {
        // write code here
        int n = nums.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = 1;
        for(int i=n-2;i>=0;--i){
            if(nums.charAt(i)=='0'){
                return 0;
            }else{
                dp[i] = dp[i+1];
                if(nums.charAt(i)<='2'&&nums.charAt(i+1)<='6'){
                    dp[i]+= dp[i+2];
                }
            }
        }
        return dp[0];
    }
}
