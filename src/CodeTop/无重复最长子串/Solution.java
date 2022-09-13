package CodeTop.无重复最长子串;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abba");
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxLen = -1;

        while (right < s.length() && left <= right){
            //右指针指向字符已存在
            if(map.containsKey(chars[right])){
                maxLen = maxLen > (right - left) ? maxLen : (right -left);
                left = left > (map.get(chars[right]) + 1) ? left : (map.get(chars[right]) + 1);
            }
            map.put(chars[right],right);
            ++right;
        }
        maxLen = maxLen > (right - left) ? maxLen : (right -left);
        return maxLen;
    }
}
