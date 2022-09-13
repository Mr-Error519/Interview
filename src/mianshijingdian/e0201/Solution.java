package mianshijingdian.e0201;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class mianshijingdian.ListNode {
 *     int val;
 *     mianshijingdian.ListNode next;
 *     mianshijingdian.ListNode(int x) { val = x; }
 * }
 */



//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
public class Solution {
    Set<Integer> set = new HashSet<>();
    class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  //解一 递归
    public ListNode removeDuplicateNodes(ListNode head) {

        if(head==null){
            return null;
        }else {
            if(set.contains(head.val)){
                return removeDuplicateNodes(head.next);
            }
            set.add(head.val);
            head.next = removeDuplicateNodes(head.next);
            return head;
        }
    }
    //
    public ListNode removeDuplicateNodes1(ListNode head) {
        if(head==null){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode cur = head;
        while(cur.next!=null){
            if(set.add(cur.next.val)){
                //set.add(cur.val);
                cur = cur.next;
            }else{
                cur.next = cur.next.next;
            }
        }
        return head;
    }
}
