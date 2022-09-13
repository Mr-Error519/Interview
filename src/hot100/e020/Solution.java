package hot100.e020;

import java.util.HashMap;
import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');


        if(s.length()%2==1){
            return false;
        }

        for(char c:s.toCharArray()){

            //每次取到'],),}'都必须与前一个配对，否则返回false
            if(map.containsKey(c)){
                if(stack.empty()||stack.pop()!=map.get(c)){
                    return false;
                }
            }else {
                stack.push(c);
            }

        }

        if(stack.empty())
            return true;
        return false;
    }
}
