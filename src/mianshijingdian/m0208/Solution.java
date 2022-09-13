package mianshijingdian.m0208;

import mianshijingdian.e0207.ListNode;

import java.util.HashSet;

//给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> listNodes = new HashSet<>();
        while (head!=null){
            //add第一次为false时，说明遇到重复节点，直接return
            if(!listNodes.add(head)){
                return head;
            }
            head = head.next;
        }
        //移动到null，无环
        return null;

    }
    public ListNode detectCycle1(ListNode head){
        //快慢指针
        //快慢指针相遇时将快指针移至表头结点，再次和慢节点相遇时的位置即是环路头节点
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
