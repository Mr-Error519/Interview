package niuke.链表.bm11;

import mianshijingdian.ListNode;

public class Solution {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        int ax = 0;
        ListNode h1 = reverse(head1);
        ListNode h2 = reverse(head2);
        ListNode res = new ListNode(0);

        while(h1!=null||h2!=null){
            int sum = 0;
            if(h1==null||h2==null){
                if(h1==null){
                    sum+=h2.val+ax;
                    h2 = h2.next;
                }else{
                    sum+=h1.val+ax;
                    h1 = h1.next;
                }
            }else{
                sum = h1.val+h2.val+ax;
                h1 = h1.next;
                h2 = h2.next;
            }


            if(sum>=10){
                sum-=10;
                ax = 1;
            }else{
                ax = 0;
            }
            ListNode temp = new ListNode(sum);
            temp.next = res.next;
            res.next = temp;


        }
        //头插法
        if(ax!=0){
            ListNode temp = new ListNode(ax);
            temp.next = res.next;
            res.next = temp;
        }
        return res.next;

    }

    public ListNode reverse(ListNode head){
        ListNode node = head;
        ListNode pre = null;
        ListNode next = null;
        while(node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        Solution solution = new Solution();
        solution.addInList(listNode1,listNode4);
    }
}
