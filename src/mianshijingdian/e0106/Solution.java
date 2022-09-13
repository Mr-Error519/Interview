package mianshijingdian.e0106;
//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。
// 若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
public class Solution{
    //解一：新建数组，遍历字符串数组
    public String compressString(String S) {
        char[] s = S.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < s.length; i++) {
            int n = 1;
            for (int j = i + 1; j < s.length; j++) {
                //遍历字符串数组统计字符个数
                if (s[j] == s[i]) {
                    n++;
                } else {
                    break;
                }
            }
            if (n > 1) {
                i += n - 1;
            }
            stringBuffer.append(s[i]);
            stringBuffer.append(n);

        }
        String S1 = stringBuffer.toString();
        if (S1.length() >= S.length()) {
            return S;
        } else {
            return S1;
        }
    }
    public String compressString1(String S){
            if (S.length() < 2)
                return S;
            // 快慢双指针
            int left = 0;
            int right = 1;
            StringBuilder sb = new StringBuilder();  // 存储压缩后的字符
            while (right <= S.length() - 1){
                // 相邻两个字符不同，则将前面字符存入sb，并right-left作为数字紧接着存入
                if (S.charAt(left) != S.charAt(right)){
                    sb.append(S.charAt(left));
                    sb.append(right - left);
                    left = right;  // 新的left从right的位置出发
                    right++;  // right指针向后移动一位
                }
                // 相邻字符相同，right指针往后移动，从而使得right-left代表重复元素的个数
                else
                    right++;
            }

            // right走到S.length()索引，对于最后一个字符（left指向的字符）要进行append
            sb.append(S.charAt(left));
            sb.append(right - left);

            // 若“压缩”后的字符串没有变短，则返回原先的字符串
            if (sb.length() < S.length()){
                return sb.toString();
            }
            else
                return S;
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = solution.compressString("aabcccccaa");
        System.out.println(a);

    }


}
