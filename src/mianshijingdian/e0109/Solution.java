package mianshijingdian.e0109;

public class Solution {
    //字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
    public boolean isFlipedString(String s1, String s2) {
//        if (s1.equals(s2)) {
//            return true;
//        }
//        int i=0;
//        int j=0;
//        //以两个字符串首字符分别作为参考，划分为两个子串 X
//        if(s1.indexOf(s2.charAt(0))!=-1&&s2.indexOf(s1.charAt(0))!=-1){
//            i = s1.indexOf(s2.charAt(0));
//            j = s2.indexOf(s1.charAt(0));
//        }else {
//            return false;
//        }
//        char[] S1 = s1.toCharArray();
//        char[] S2 = s2.toCharArray();
//
//        //子字符串长度不等
//        if (s1.length() - i != j && s2.length() - j != i) {
//            return false;
//        }
//
//        int m = 0;
//        for (int k = 0; k < s2.length(); k++) {
//            if (k < j) {
//                if (S2[k] != S1[i]) {
//                    return false;
//                }
//                i++;
//            } else {
//                if (S2[k] != S1[m]) {
//                    return false;
//                }
//                m++;
//            }
//
//        }
//        return true;

        // 长度不相等，肯定不符合要求
        if (s1.length() != s2.length()) {
            return false;
        }

        // 长度相等时，若s2是s1旋转而成的，那么把s2和自身拼接一次，s1就会出现在其中
        // "erbottlewat" + "erbottlewat" = erbottle waterbottle wat
        // 如果s2不是s1旋转而成的，那么那么把s2和自身拼接一次，s1就肯定不会出现在其中
        return (s2 + s2).indexOf(s1) != -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        if(solution.isFlipedString("PvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmb","SvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDW"))
        { System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
//        solution.isFlipedString("", "");

}
