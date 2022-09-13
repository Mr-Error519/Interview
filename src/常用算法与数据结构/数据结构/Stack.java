package 常用算法与数据结构.数据结构;

import java.util.Deque;
import java.util.LinkedList;

public class Stack {
    public static void main(String[] args) {
        Deque<Integer> stack = new LinkedList<>();

        //入栈
        stack.push(1);

        //出栈
        stack.pop();

        //返回栈顶元素
        stack.peek();
    }
}
