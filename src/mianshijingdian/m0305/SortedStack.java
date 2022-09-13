package mianshijingdian.m0305;
//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

import java.util.Stack;

public class SortedStack {
    Stack<Integer> stack;
    Stack<Integer> tmp;
    public SortedStack() {
        stack = new Stack<Integer>();
        tmp = new Stack<Integer>();
    }

    public void push(int val) {
        //先对isEmpty进行判断
        while(!stack.isEmpty() && stack.peek() < val){
            tmp.push(stack.pop());
        }
        stack.push(val);
        while (!tmp.isEmpty()){
            stack.push(tmp.pop());
        }

    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
