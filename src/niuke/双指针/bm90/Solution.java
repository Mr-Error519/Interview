package niuke.双指针.bm90;

import java.util.HashMap;

public class Solution {
    public String minWindow (String S, String T) {
        // write code here
        int left = 0;
        int right = 0;
        int start = 0;
        int end = -1;
        int minlen = Integer.MAX_VALUE;
        int size = 0;
        HashMap<Character,Integer> window = new HashMap<>();
        HashMap<Character,Integer> t = new HashMap<>();

        if(T.length()>S.length()) return "";
        for(int i=0;i<T.length();++i){
            t.put(T.charAt(i),t.getOrDefault(T.charAt(i),0)+1);
        }

        while(right<S.length()){
            char c = S.charAt(right);
            window.put(c,window.getOrDefault(c,0)+1);
            if(t.get(c)!=null&&window.get(c).equals(t.get(c))){
                ++size;
            }
            ++right;
            while(size==t.size()){
                if(right-left<minlen){
                    minlen = right-left;
                    start = left;
                    end = right;
                }
                char c1 = S.charAt(left);
                window.put(c1,window.get(c1)-1);
                if(t.get(c1)!=null&&window.get(c1)<t.get(c1)){
                    --size;
                }
                ++left;
            }

        }
        if(end<start) return "";
        return S.substring(start,end);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = new String("XDOYEZODEYXNZ");
        String s2 = new String("XYZ");
        solution.minWindow(s1,s2);
    }
}
