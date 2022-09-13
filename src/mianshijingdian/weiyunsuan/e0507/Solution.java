package mianshijingdian.weiyunsuan.e0507;

//配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
public class Solution {
    public int exchangeBits(int num) {
        //奇数
        int odd = num & 0x55555555;
        //偶数
        int even = num & 0xaaaaaaaa;
        odd = odd << 1;
        even = even >>> 1;
        return odd | even;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.exchangeBits(188));
    }
}
