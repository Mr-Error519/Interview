package mianshijingdian.e0302;

//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。

import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    Deque<Integer> xstack;
    Deque<Integer> minstack;

    /** initialize your data structure here. */
    public MinStack() {
        xstack = new LinkedList<>();
        minstack = new LinkedList<>();
        minstack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xstack.push(x);
        minstack.push(Math.min(minstack.peek(),x));
    }

    public void pop() {
        xstack.pop();
        minstack.pop();
    }

    public int top() {
        return xstack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
public class Solution {

}
