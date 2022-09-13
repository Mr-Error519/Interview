package 常用算法与数据结构.数据结构;

import java.util.Deque;
import java.util.LinkedList;

public class Queue {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();

        //入队
        queue.offer(1);

        //出队
        queue.poll();

        queue.size();
    }
}
