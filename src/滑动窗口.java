import java.util.HashMap;
import java.util.Map;

public class 滑动窗口 {
    public static void main(String[] args) {
        String str1 = "ADOBECODEBANC";
        String str2 = "ABC";
        System.out.println(minWindow("a", "b"));
    }

    static String minWindow(String str1, String str2){
        int left = 0;
        int right = left;
        String minLenSubstr = str1;
        while(right < str1.length()) {
            String substr = str1.substring(left, right);
            while(!justify(substr, str2) && right < str1.length()){
                right ++;
                substr = str1.substring(left, right);
            }
            if (justify(substr, str2)){
                //说明有子串str2
                while(justify(substr, str2) && left < right){
                    if (substr.length() < minLenSubstr.length()){
                        minLenSubstr = substr;
                    }
                    left++;
                    substr = str1.substring(left, right);
                }
            }
        }
        if (minLenSubstr.length() < str2.length() || minLenSubstr.equals(str1)){
            return "";
        }
        return minLenSubstr;
    }

    private static boolean justify(String substr, String str2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < substr.length(); ++i){
            map.put(substr.charAt(i), map.getOrDefault(substr.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str2.length(); ++i){
            char ch = str2.charAt(i);
            int now = map.getOrDefault(ch, 0) - 1;
            if (now < 0){
                return false;
            }
            map.put(ch, now);

        }
        return true;
    }
}
