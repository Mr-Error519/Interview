package mianshijingdian.e0104;

import java.util.HashMap;

public class Solution {
    //给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
    //回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
    //回文串不一定是字典当中的单词。
    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar,0);
        }
        for (char aChar : chars) {
            map.put(aChar,map.get(aChar)+1);
        }
        int i = 0;
        for (Character character : map.keySet()) {
            if(map.get(character)%2!=0){
                i++;
            }
        }
        if(i>1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canPermutePalindrome("tactcoa");
    }
}
