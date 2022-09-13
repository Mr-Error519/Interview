package mianshijingdian.weiyunsuan.e0501;

import java.util.ArrayList;

public class Solution {
    //给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
    //编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。
    public int insertBits(int N, int M, int i, int j) {
        String bN = Integer.toBinaryString(N);
        String bM = Integer.toBinaryString(M);
        char[] mchars = bM.toCharArray();
        int len;
        ArrayList<Character> nchars = new ArrayList<Character>();
        if(N==0){
            for (int k = 0; k <mchars.length ; k++) {
                nchars.add('0');
            }
        }else {
            char[] chars = bN.toCharArray();
            for (int k = 0; k <bN.length() ; k++) {
                nchars.add(chars[k]);
            }
            if(chars.length<j+1){
                for (int k = 0; k <j+1-chars.length ; k++) {

                    nchars.add(0,'0');
                }
            }

        }

        //记录已经插入的数字个数，超过m长度需用0补齐
        int n = 0;
        int m;
        for ( m = nchars.size()-i-1;m>=nchars.size()-j-1;m--){

            if(n>bM.length()-1){
                nchars.set(m,'0');
            }else {
                nchars.set(m,mchars[mchars.length-n-1]);
            }
            n++;
        }
        Character[] characters = nchars.toArray(new Character[nchars.size()]);
        char[] chars = new char[characters.length];
        for (int k = 0; k <characters.length ; k++) {
            chars[k] = characters[k];
        }
        String s = String.copyValueOf(chars);
        System.out.println(s);
        //字符串转为整数
        return Integer.parseInt(s.trim(),2);


    }
    public int insertBits1(int N, int M, int i, int j) {
        //位运算
        // 先把相应的位置零
        int allOnes = ~0;
        System.out.println(allOnes);
        int left = j == 31 ? 0 : (allOnes << (j + 1));
        System.out.println(allOnes);
        int right = (1 << i) - 1;
        int mask = (left | right);
        System.out.println(Integer.toBinaryString(N));
        N &= mask;
        System.out.println(Integer.toBinaryString(N));
        System.out.println(Integer.toBinaryString(M));
        M <<= i;
        System.out.println(Integer.toBinaryString(M));
        return N | M;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.insertBits1(126194517,2982082,9,30);
        System.out.println(i);
    }

}
