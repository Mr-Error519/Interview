package mianshijingdian.e0101;
//要求：实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
class Solution {

    public boolean isUniq1(String astr){
        //将astr转成数组，从第一个字符开始循环向后面的每一个字符做比较
        /*
        减少复杂度操作：
        1
         */
        char[] a =astr.toCharArray();
        for (int i = 0; i <a.length ; i++) {
            for(int j = i+1;j<a.length;j++){

                //如果存在字符相等直接return
                if(a[i]==a[j]){
                    return false;
                }

            }

        }
        //结束全部比较没有相等情况
        return true;

    }
    public boolean isUniq2(String astr){
        //将astr转成字符数组，从第一个字符开始判断字符在字符串中
        char[] a =astr.toCharArray();
        for (int i = 0; i <a.length ; i++) {
                //如果字符在数组中的位置与第一次出现的索引不同则说明存在重复直接return
                //str.indexOf报告指定字符在此实例中的第一个匹配项的索引
                if(astr.indexOf(a[i])!=i){
                    return false;
                }

            }

        //结束全部比较没有相等情况
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isUniq2("abc"));
    }

}


