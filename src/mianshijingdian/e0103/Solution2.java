package mianshijingdian.e0103;

//利用StringBuilder类
public class Solution2 {
    public String replaceSpaces(String S, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        //逐渐遍历字符串
        for (int i = 0; i < length; i++) {
            //如果不是空格就加入到StringBuilder中，如果是空格
            //就把"%20"加入到StringBuilder中
            char ch = S.charAt(i);
            if (ch == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

}
