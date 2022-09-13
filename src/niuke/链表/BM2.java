package niuke.链表;

import mianshijingdian.ListNode;

public class BM2 {
    //指定区间翻转
    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode late = pre;
        int index = 1;
        while(index<n+1){
            if(index<m) {
                pre = pre.next;
            }
            late = late.next;
            ++index;
        }
        pre.next = reverse(pre.next,late.next);
        return dummy.next;
    }
    public ListNode reverse(ListNode h,ListNode pre){
        ListNode cur = h;
        ListNode next = null;
        ListNode j = pre;
        while(cur!=j){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        BM2 bm2 = new BM2();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        bm2.reverseBetween(listNode,2,4);
    }
}
