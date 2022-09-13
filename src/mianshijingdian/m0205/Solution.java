package mianshijingdian.m0205;

import mianshijingdian.ListNode;

//给定两个用链表表示的整数，每个节点包含一个数位。
//
//这些数位是反向存放的，也就是个位排在链表首部。
//
//编写函数对这两个整数求和，并用链表形式返回结果。
public class Solution {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //进位
        int x = 0;
        //记录每一位相加的值
        int sum = 0;
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += x;
            x = sum / 10;
            sum = sum % 10;
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
            sum = 0;
        }
        if(x!=0){
            tmp.next = new ListNode(x);
        }
        return head;
    }









//        int x = 0;  // 进位
//        mianshijingdian.ListNode dummy = new mianshijingdian.ListNode(0);   // 哑节点
//        mianshijingdian.ListNode node = dummy;
//
//        while(l1 != null || l2 != null || x != 0) {
//            int sum = x;    // 当前位的和
//            if (l1 != null) {
//                sum += l1.val;
//                l1 = l1.next;
//            }
//            if (l2 != null) {
//                sum += l2.val;
//                l2 = l2.next;
//            }
//            node.next = new mianshijingdian.ListNode(sum % 10);
//            x = sum / 10;
//            node = node.next;
//        }
//        return dummy.next;




    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
//        head1.next = new mianshijingdian.ListNode(4);
//        head1.next.next = new mianshijingdian.ListNode(3);
        ListNode head2 = new ListNode(1);
        ListNode tmp = head2;
        for (int i = 0; i < 9; i++) {
            tmp.next = new ListNode(9);
            tmp = tmp.next;
        }
//        head2.next = new mianshijingdian.ListNode(6);
//        head2.next.next = new mianshijingdian.ListNode(4);
        Solution solution = new Solution();
        ListNode head = solution.addTwoNumbers1(head1,head2);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
//        double i = 999999991+9*Math.pow(10,9);
//        System.out.println(i);
    }
}
