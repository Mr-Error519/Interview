package hot100.m003;

import java.util.HashMap;
import java.util.HashSet;

////给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars=s.toCharArray();
        int len=0;
        int max=0;
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<chars.length;++i){
            set.add(chars[i]);
            ++len;
            for(int j=i+1;j<chars.length;++j){

                if(set.add(chars[j])){
                    ++len;
                }else{
                    if(len>max){
                        max=len;
                    }
                    len=0;
                    set.clear();
                    break;
                }
                if(j==chars.length-1){
                    if(len>max){
                        max=len;
                    }
                    len=0;
                }

            }
        }
        if(len>max){
            max=len;
        }
        return max;
    }
    public int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("au");

    }
}
