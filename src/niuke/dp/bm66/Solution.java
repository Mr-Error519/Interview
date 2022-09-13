package niuke.dp.bm66;

public class Solution {
    public String LCS (String str1, String str2) {
        // write code here
        int rows = str1.length();
        int cols = str2.length();
        int[][] dp = new int[rows+1][cols+1];
        int maxlength = 0;
        int lastindex = 0;
        for(int i=1;i<=rows;++i){
            for(int j=1;j<=cols;++j){
                if(str2.charAt(j-1)==str1.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if(dp[i][j]>maxlength) {
                        maxlength = dp[i][j];
                        lastindex = j;
                    }
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        return str2.substring(lastindex-maxlength+1,lastindex);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.LCS("1AB2345CD","12345EF");
    }
}
