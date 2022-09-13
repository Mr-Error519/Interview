package hot100.m019;

import mianshijingdian.ListNode;


import java.util.Stack;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res=head;
        Stack<ListNode> stack = new Stack<>();
        ListNode prev=null;
        ListNode after=null;
        int k=0;

        if(head==null){
            return null;
        }

        while (head!=null){
            stack.push(head);
            head=head.next;
            ++k;
        }

        if(n==k){
            return res.next;
        }


        for (int i = 0; i <=n ; ++i) {
            if(n==1){
                stack.pop();
                prev=stack.pop();
                prev.next=null;
                return res;
            }else {
                if(i==n-2){
                    after=stack.peek();
                }

                if(i==n){
                    prev=stack.pop();
                    prev.next=after;
                    return res;
                }

                stack.pop();
            }
        }
        return res;
    }
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while(n != 0) {
            start = start.next;
            n--;
        }
        while(start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);
        solution.removeNthFromEnd(listNode,2);

    }
}
