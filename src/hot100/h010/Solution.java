package hot100.h010;

//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//'.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
//所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
public class Solution {
    public boolean isMatch(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        int indexs=0;
        int indexp=0;

        while(indexp<chp.length&&indexs<chs.length){

            if(indexp+1<chp.length) {
                if (chp[indexp + 1] != '*') {
                    if (chp[indexp] != chs[indexs] && chp[indexp] != '.') {
                        return false;
                    } else {
                        ++indexp;
                        ++indexs;
                        continue;
                    }
                }

                if (chp[indexp + 1] == '*') {
                    if (chp[indexp] != chs[indexs] && chp[indexp] != '.') {
                        ++indexs;
                        ++indexp;
                        ++indexp;
                        continue;
                    }
                    if (chp[indexp] != chs[indexs] && chp[indexp] == '.') {
                        if ((indexp + 2) > chp.length) {
                            return true;
                        } else {
                            while (indexs < chs.length && chs[indexs] != chp[indexp + 2]) {
                                ++indexs;
                            }
                            ++indexp;
                            ++indexp;
                            continue;
                        }

                    }
                    if (chp[indexp] == chs[indexs]) {
                        if (indexp + 2 < chp.length) {
                            if (chp[indexp] != chp[indexp + 2]) {
                                while (indexs < chs.length && chs[indexs] == chp[indexp]) {
                                    ++indexs;
                                }
                                ++indexp;
                                ++indexp;
                                continue;
                            } else {
                                while (indexs < chs.length && chs[indexs] == chp[indexp]) {
                                    ++indexs;
                                }
                                --indexs;
                                ++indexp;
                                ++indexp;
                                continue;
                            }
                        } else {
                            while (indexs < chs.length && chs[indexs] == chp[indexp]) {
                                ++indexs;
                            }
                            ++indexp;
                            ++indexp;
                            continue;
                        }
                    }

                } else {
                    if (chp[indexp] != chs[indexs]) {
                        return false;
                    } else {
                        ++indexs;
                        ++indexp;
                        continue;
                    }
                }
            }
        }
        if(indexp<chp.length||indexs<chs.length){
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        if(solution.isMatch("aaa","a*a")){
            System.out.println("true");
        }

    }
}
