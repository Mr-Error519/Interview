package niuke.堆栈队列.bm49;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Solution {
    public int solve (String s) {
        // write code here
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);

        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();
        char[] s1 = s.toCharArray();

        for(int i=0;i<s1.length;++i){
            char c = s1[i];
            if(c=='('){
                ops.addLast(c);
            }else if(c==')'){
                while(ops.peekLast()!='('){
                    calc(nums,ops);
                }
                ops.pollLast();
            }else{
                if(Character.isDigit(c)){
                    int u = 0;
                    int j = i;
                    while(j<s1.length&&s1[j]>='0'&&s1[j]<='9'){
                        u = u*10+s1[j++]-'0';
                    }
                    nums.addLast(u);
                    i = j-1;
                }else{
                    while(!ops.isEmpty()&&ops.peekLast()!='('){
                        char prev = ops.peekLast();
                        if(map.get(prev)>=map.get(c)){
                            calc(nums,ops);
                        }else{
                            break;
                        }
                    }
                    ops.addLast(c);
                }
            }
        }
        while(!ops.isEmpty()){
            calc(nums,ops);
        }
        return nums.pollLast();
    }

    public void calc(Deque<Integer> nums, Deque<Character> ops){
        if(nums.size()<2||ops.size()<1) return;
        int b = nums.pollLast();
        int a = nums.pollLast();
        char c = ops.pollLast();

        switch(c){
            case('+'):
                nums.addLast(a+b);
                break;

            case('-'):
                nums.addLast(a-b);
                break;

            case('*'):
                nums.addLast(a*b);
        }

        return;
    }

    public static void main(String[] args) {
        String s = new String("1+2");
        Solution solution = new Solution();
        solution.solve(s);
    }
}
