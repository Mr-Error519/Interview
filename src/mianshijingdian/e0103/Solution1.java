package mianshijingdian.e0103;

public class Solution1 {
    public String replaceSpaces(String s,int length){
        //只转换length长度内出现的空格字符
        //遍历字符串数组，空格出现的地方替换为特殊字符，再将数组转为字符串，接着字符串将特殊字符替换为%20
        //字符串”*“与字符‘*’有差别，无法实现
//        char[] a = s.toCharArray();
//        for (int i = 0; i <a.length ; i++) {
//            //判断是否超过字符串真实长度
//            if(length<=0){
//                break;
//            }
//            if(a[i]==' '){
//                a[i]='*';
//            }
//            length--;
//        }
//        //copyValueOf()--String类静态方法,字符串数组转为String
//        String s1 = String.copyValueOf(a);
//        s1.replace("%20","*");
        /*
        新建一个字符数组
         */
        char[] b = new char[500000*3];
        char[] a =s.toCharArray();
        int j = 0;
        for (int i = 0; i <length ; i++) {

            if(length<=0){
                break;
            }
            else {
                if(a[i]==' '){
                    b[j]='%';
                    b[j+1]='2';
                    b[j+2]='0';
                    j+=3;
                }
                else {
                    b[j]=a[i];
                    j+=1;
                }
//                length--;
            }

        }
//        char[] c = new char[j];
//        for (int i = 0; i < j; i++) {
//            c[i]=b[i];
//        }
//        String s1 = String.copyValueOf(c);
        String s2 = new String(b, 0, j);
        return s2;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.replaceSpaces("         ",5);
        System.out.println("------------");
        String a = solution.replaceSpaces("         ",5);
        System.out.println(a);
//        System.out.println(solution.replaceSpaces("         ",5));
    }
}
