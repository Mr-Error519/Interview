package hot100.m005;

//给你一个字符串 s，找到 s 中最长的回文子串。
public class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        int left=0;
        int right=0;
        char[] chars = s.toCharArray();

        for (int i = 0; i <chars.length ; ++i) {
            boolean flag=true;
            for (int j = chars.length-1; j >0 ; ++j) {

                if(flag){
                    left=i;
                    right=j;
                    flag=false;
                }

                //left和right相遇
                if(left>=right){
                    if(j-i>end-start){
                        start=i;
                        end=j;
                        break;
                    }
                }

                if(chars[left]!=chars[right]){
                    continue;
                }else {
                    ++left;
                    --right;
                }
            }
        }

        return s.substring(start,end);
    }
    public String longestPalindrome1(String s) {
        int max=0;
        int start=0;
        int end=0;

        if(s.length()<2){
            return s;
        }

        for (int i = 1; i <s.length() ; i++) {
            int len1=len(s,i,i);
            int len2=len(s,i,i+1);
            int length=len1>len2?len1:len2;
            if(length>max){
                start=i-(length-1)/2;
                end=i+length/2;
            }
        }
        return s.substring(start,end+1);
    }
    public int len(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            --left;
            ++right;
        }
        return right-left-1;
    }
}
