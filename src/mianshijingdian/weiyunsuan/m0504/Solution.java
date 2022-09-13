package mianshijingdian.weiyunsuan.m0504;

//下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
public class Solution {
    public int[] findClosedNumbers(int num) {
        int[] i = new int[2];
        if(num== 2147483647){
            i[0] = -1;
            i[1] = -1;
            return i;
        }
        String s = Integer.toBinaryString(num);
        char prev = '0';
        int k = 0;
        int pos = 0;
        if (s.length()==31){
            char[] charsbig = s.toCharArray();
            char[] charssmall =s.toCharArray();
            //比num大
            for (int j = charsbig.length-1; j >=0 ; j--) {
                if(charsbig[j]=='0'&&prev=='1'){
                    charsbig[j] = '1';
                    charsbig[j+1] = '0';
                    pos = j;
                    break;
                }
                prev = charsbig[j];
            }
            for (int j = charsbig.length-1; j >pos+1 ; j--) {
                if(charsbig[j]=='0'){
                    k++;
                }
            }
            for (int j = pos+2; j <charsbig.length ; j++) {
                if(k>0){
                    charsbig[j]='0';
                    k--;
                }else {
                    charsbig[j]='1';
                }
            }
            //比num小
            prev = '1';
            pos = 0;
            boolean flag = true;
            for (int j = charssmall.length-1; j >=0 ; j--) {
                if(charssmall[j]=='1'&&prev=='0'){
                    charssmall[j] = '0';
                    charssmall[j+1] = '1';
                    pos = j;
                    flag = false;
                    break;
                }
                prev = charssmall[j];

            }
            if(flag==false){
                k = 0;
                for (int j = charssmall.length-1; j >pos+1 ; j--) {
                    if(charssmall[j]=='1'){
                        k++;
                    }
                }
                for (int j = pos+2; j <charssmall.length ; j++) {
                    if(k>0){
                        charssmall[j]='1';
                        k--;
                    }else {
                        charssmall[j]='0';
                    }
                }
                i[1] = Integer.parseInt(String.copyValueOf(charssmall).trim(),2);
                System.out.println("比num小:"+String.copyValueOf(charssmall));
            }else {
                i[1] = -1;
                System.out.println("比num小:"+String.copyValueOf(charssmall));
            }
            i[0] = Integer.parseInt(String.copyValueOf(charsbig).trim(),2);

        }else {
            System.out.println("初始num:"+s);
            char[] charsbig = new char[s.length()+1];
            char[] chars = s.toCharArray();
            char[] charssmall =new char[s.length()+1];
            for (int j = 0; j < s.length()+1; j++) {
                if(j==0){
                    charsbig[j] = '0';
                    charssmall[j] = '0';
                }else {
                    charsbig[j] = chars[j-1];
                    charssmall[j] = chars[j-1];
                }
            }
            //比num大
            for (int j = charsbig.length-1; j >=0 ; j--) {
                if(charsbig[j]=='0'&&prev=='1'){
                    charsbig[j] = '1';
                    charsbig[j+1] = '0';
                    pos = j;
                    break;
                }
                prev = charsbig[j];
            }
            for (int j = charsbig.length-1; j >pos+1 ; j--) {
                if(charsbig[j]=='0'){
                    k++;
                }
            }
            for (int j = pos+2; j <charsbig.length ; j++) {
                if(k>0){
                    charsbig[j]='0';
                    k--;
                }else {
                    charsbig[j]='1';
                }
            }
            //比num小
            prev = '1';
            pos = 0;
            boolean flag = true;
            for (int j = charssmall.length-1; j >=0 ; j--) {
                if(charssmall[j]=='1'&&prev=='0'){
                    charssmall[j] = '0';
                    charssmall[j+1] = '1';
                    pos = j;
                    flag = false;
                    break;
                }
                prev = charssmall[j];

            }
            if(flag==false){
                k = 0;
                for (int j = charssmall.length-1; j >pos+1 ; j--) {
                    if(charssmall[j]=='1'){
                        k++;
                    }
                }
                for (int j = pos+2; j <charssmall.length ; j++) {
                    if(k>0){
                        charssmall[j]='1';
                        k--;
                    }else {
                        charssmall[j]='0';
                    }
                }
                i[1] = Integer.parseInt(String.copyValueOf(charssmall).trim(),2);
                System.out.println("比num小:"+String.copyValueOf(charssmall));
            }else {
                i[1] = -1;
                System.out.println("比num小:"+String.copyValueOf(charssmall));
            }
            i[0] = Integer.parseInt(String.copyValueOf(charsbig).trim(),2);
        }



        return i;
    }
    public int[] findClosedNumbers1(int num) {
        int count = 0;//记录1的数量
        int big = -1, small = -1;
        int numTmp = num;
        for(int i = 0; i < 30; i++){
            //较大的数：遇到第一个01，变成10,并把右侧的1放到低位
            if((num &(1 << i)) != 0 && (num & (1 << i + 1)) == 0){
                numTmp += (1 << i + 1);
                numTmp -= (1 << i);
                for(int j = 0; j < count; j++){
                    numTmp += (1 << j);
                }
                big = numTmp;
                break;
            }
            if((num & (1 << i)) != 0) count++;
            numTmp &= (~(1 << i));
        }
        numTmp = num;
        count = 0;
        for(int i = 0; i < 30; i++){
            //较小的数：遇到的第一个10.变成01，并把右侧的1全放到高位
            if((num & (1 << i)) == 0 && (num & (1 << i + 1)) != 0){
                numTmp -= (1 << i + 1);
                numTmp += (1 << i);
                for(int j = 0; j < count; j++){
                    numTmp += (1 << i - j - 1);
                }
                small = numTmp;
                break;
            }
            if((num & (1 << i)) != 0) count++;
            numTmp &= (~(1 << i));
        }
        return new int[]{big, small};

    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.findClosedNumbers(1837591841);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
//        char[] chars = {'1', '0', '0', '0', '1', '1', '1', '1'};
//        System.out.println(Integer.parseInt(String.copyValueOf(chars),2));
    }
}
