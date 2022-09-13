package hot100.m006;

import java.util.ArrayList;
import java.util.List;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
public class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> lis=new ArrayList<>();
        for (int i = 0; i <numRows ; i++) {
            lis.add(new StringBuilder());
        }
        //true时++index
        boolean flag=true;
        int index=0;
        char[] chars = s.toCharArray();
        if(numRows==1){
            return s;
        }
        for (int i = 0; i <s.length() ; i++) {
            if(flag){
                //index已达到最大值
                if(index==(numRows-1)){
                    flag=false;
                    lis.get(index).append(chars[i]);
                    --index;
                    continue;
                }
                lis.get(index).append(chars[i]);
                ++index;
            }else {
                if(index==0){
                    flag=true;
                    lis.get(index).append(chars[i]);
                    ++index;
                    continue;
                }
                lis.get(index).append(chars[i]);
                --index;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <numRows ; i++) {
            res.append(lis.get(i));
        }
        return res.toString();
    }
    /*/
    if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();

     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("AB",1));

    }
}
