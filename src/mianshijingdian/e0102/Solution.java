package mianshijingdian.e0102;

//判定是否互为字符重排
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

import java.util.HashMap;

public class Solution {

    //判定两个字符串包含的元素相同且相同元素个数相同
    public boolean CheckPermutation(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        char[] a = s1.toCharArray();
        //hashmap统计s1
        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();
        for (int i=0;i<a.length;i++){
            //s2中不包含s1的字符元素
            if(s2.indexOf(a[i])==-1){
                return false;
            }
            //该元素重复出现,且该元素不是第一次出现
            if(s1.indexOf(a[i])!=s1.lastIndexOf(a[i])&&i!=s1.indexOf(a[i])){
                //values值+1
                hashMap.put(a[i],hashMap.get(a[i])+1);
            }
            else {

                //每个第一次出现的元素赋给map，value=1
                hashMap.put(a[i],1);
            }
        }
//        //统计s2字符个数情况
//        char[] a1 = s2.toCharArray();
//        for (int i = 0; i <a1.length ; i++) {
//            int n = 1;
//            for (int j = 0; j <a1.length ; j++) {
//                if(i==j){
//                    continue;
//                }
//                if(a1[i]==a1[j]){
//                    n++;
//                }
//            }
            //如果a1[i]在s2重复出现的次数和在s1重复出现次数不等则不能重新排列
//            if(n!=hashMap.get(a1[i])){
//                return false;
//            }
        //统计s2字符个数情况
        //遍历s2字符数组，每取一个字符，s1对应hashmap字符的value值减一
        char[] a1 = s2.toCharArray();
        for (int i = 0; i <a1.length ; i++) {
            hashMap.put(a1[i],hashMap.get(a1[i])-1);
            if (hashMap.get(a1[i])<0){
                return false;
            }
        }
        for (char s:s2.toCharArray()) {
            hashMap.put(s,hashMap.get(s)-1);
            if (hashMap.get(s)<0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.CheckPermutation("asvnpzurz","urzsapzvn"));

    }

}
