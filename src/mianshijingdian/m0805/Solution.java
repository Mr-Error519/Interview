package mianshijingdian.m0805;

public class Solution {
    //递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
    public int multiply(int A, int B) {
        if(B==0){
            return 0;
        }
        return multiply(A,B-1)+A;
    }
}
