package mianshijingdian.e0801;

//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。

public class Solution {
    public int waysToStep(int n) {
        if (n == 0||n == 1) {
            return 1;
        }
        if(n-3>=0){
            return (waysToStep(n-1)+waysToStep(n-2)+waysToStep(n-3))%1000000007;
        }else {
                return (waysToStep(n-1)+waysToStep(n-2))%1000000007;
        }


    }

    public int waysToStep1(int n) {
        if (n <= 1) {
            return n+1;
        }
        if(n==2){
            return 4;
        }
        long mod = 1000000007;
        long[] dp = new long[n];
        dp[0]=1;
        dp[1]=2;
        dp[2]=4;
        for (int i = 3; i <n ; i++) {
            dp[i]=dp[i-1]%mod+dp[i-2]%mod+dp[i-3]%mod;
        }
        int mod1 = (int)(dp[n-1]%mod);
        return mod1;








//        long MOD = 1000000007;
//        long[] dp = new long[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 2;
//        dp[3] = 4;
//
//        for (int i = 4; i <= n; i++) {
//            dp[i] = (dp[i - 1] % MOD) + (dp[i - 2] % MOD) + (dp[i - 3] % MOD);
//        }
//        int res = (int) (dp[n] % MOD);
//        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.waysToStep1(76));
    }


}
