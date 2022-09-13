package mianshijingdian.e0304;

import java.util.Stack;

//实现一个MyQueue类，该类用两个栈来实现一个队列。
class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //s2不为空时弹出s2的第一个元素
        if(!s2.empty()){
            return s2.pop();
        }
        while (!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.empty()&&s2.empty()){
            return true;
        }
        return false;
    }
}
public class Solution {
}
