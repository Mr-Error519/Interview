package niuke.dp.nc353;

public class Solution {
    public int Substrings (String str) {
        // write code here
        char[] a = str.toCharArray();
        int[] dp = new int[a.length];
        dp[0] = 1;

        for(int i=1;i<a.length;++i){
            int count = 0;
            for(int j=0;j<=i;++j){
                if(isPalindrome(str.substring(0,i+1),j,j)){
                    count++;
                }
                if(isPalindrome(str.substring(0,i+1),j,j+1)){
                    count++;
                }
            }
            dp[i] = dp[i-1]+count;
        }
        return dp[dp.length-1];
    }

    public boolean isPalindrome(String str,int left,int right){
        while(left>=0&&right<str.length()&&str.charAt(left)==str.charAt(right)){
            --left;
            ++right;
        }
        if(right<=str.length()&&left+1<str.length()&&str.charAt(left+1)==str.charAt(right-1)&&right-1==str.length()-1) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = new String("nowcoder");
        solution.Substrings(s);
    }
}
