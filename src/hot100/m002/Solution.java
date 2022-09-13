package hot100.m002;

import mianshijingdian.e0207.ListNode;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0;
        int ax=0;

        ListNode head=listCompare(l1,l2);
        ListNode temp=new ListNode(0);
        temp.next = head;

        while(l1!=null||l2!=null){
            sum=ax;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            ax=sum/10;
            sum=sum%10;
            temp.next.val=sum;
            temp=temp.next;
        }
        if(ax!=0){
            temp.next = new ListNode(ax);
        }
        return head;
    }

    public ListNode listCompare(ListNode l1,ListNode l2) {
        int i = 0;
        int j = 0;
        ListNode head1=l1;
        ListNode head2=l2;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                i++;
                l1 = l1.next;
            }
            if (l2 != null) {
                j++;
                l2 = l2.next;
            }
        }
        if (i > j) {
            return head1;
        } else {
            return head2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        ListNode head1 = listNode1;
        for (int i = 0; i <6 ; i++) {
            listNode1.next = new ListNode(9);
            listNode1 = listNode1.next;
        }

        ListNode listNode2 = new ListNode(9);
        ListNode head2 = listNode2;
        for (int i = 0; i <3 ; i++) {
            listNode2.next=new ListNode(9);
            listNode2 = listNode2.next;
        }
        Solution solution = new Solution();
        solution.addTwoNumbers(head1,head2);
    }
}
