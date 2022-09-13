package hot100.e121;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int maxProfit(int[] prices) {
        Deque<Integer> stack = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;++i){
            int j=i;
            stack.push(prices[i]);
            while(j<prices.length){
                if(prices[j]>stack.peek()){
                    stack.push(prices[j]);
                }
                ++j;
            }
            if(stack.size()==1) {
                stack.clear();
                continue;
            }
            System.out.println(stack.peek());
            System.out.println(stack.getLast());
            if((stack.peek()-stack.getLast())>max) max = stack.peek()-stack.getLast();
            stack.clear();
        }
        if(max>0) return max;
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[]{7,1,5,3,6,4});

    }
}
