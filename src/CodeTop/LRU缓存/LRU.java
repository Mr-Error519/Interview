package CodeTop.LRU缓存;

import java.util.HashMap;
import java.util.Map;

public class LRU {
//    请你设计并实现一个满足LRU (最近最少使用) 缓存 约束的数据结构。
//    实现 LRUCache 类：
//    LRUCache(int capacity) 以 正整数 作为容量capacity 初始化 LRU 缓存
//    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//    void put(int key, int value)如果关键字key 已经存在，则变更其数据值value ；如果不存在，则向缓存中插入该组key-value 。如果插入操作导致关键字数量超过capacity ，则应该 逐出 最久未使用的关键字。
//    函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

    public static void main(String[] args) {
        LRU lru = new LRU(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        lru.get(1);
        lru.get(3);
        lru.get(4);
    }

    class DoubleLinkedNode {
        int key;
        int value;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        public DoubleLinkedNode(){}
        public DoubleLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    DoubleLinkedNode head;
    DoubleLinkedNode tail;
    Map<Integer, DoubleLinkedNode> cache = new HashMap<>();
    int capacity;

    public LRU(int capacity) {
        head = new DoubleLinkedNode();
        tail = new DoubleLinkedNode();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            moveToHead(cache.get(key));
            return cache.get(key).value;
        }else{
            return -1;
        }
    }


    public void put(int key, int value) {

        if(cache.containsKey(key)){
            cache.get(key).setValue(value);
            moveToHead(cache.get(key));
        }else{
            DoubleLinkedNode node = new DoubleLinkedNode(key, value);
            if(cache.size() >= capacity){
                cache.remove(tail.prev.key);
                removeTail(tail.prev);
            }
            addToHead(node);
            cache.put(key, node);
        }
    }

    private void addToHead(DoubleLinkedNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeTail(DoubleLinkedNode node) {
        if(node.prev != null){
            node.prev.next = tail;
            tail.prev = node.prev;
        }
    }

    private void moveToHead(DoubleLinkedNode doubleLinkedNode) {
        doubleLinkedNode.prev.next = doubleLinkedNode.next;
        doubleLinkedNode.next.prev = doubleLinkedNode.prev;
        doubleLinkedNode.next = head.next;
        head.next.prev = doubleLinkedNode;
        head.next = doubleLinkedNode;
        doubleLinkedNode.prev = head;
    }
}
