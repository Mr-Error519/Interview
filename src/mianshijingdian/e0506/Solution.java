package mianshijingdian.e0506;

//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
public class Solution {
    public int convertInteger(int A, int B) {
        int C = A^B;
        int n = 0;
        System.out.println(Integer.toBinaryString(A));
        System.out.println(Integer.toBinaryString(B));
        String s = Integer.toBinaryString(C);
        System.out.println(s);
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if(aChar=='1'){
                n++;
            }
        }
//        while (C != 0){
//            //C&(C -1) 可以把temp最右边的1置0，其余位不变
//            //这样，这个操作执行了几次，就是有几位要转换
//            C = C&(C - 1);
//            n++;
        return n ;
        }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convertInteger(10,2));
    }
}
