package hot100.h023;

import mianshijingdian.ListNode;

//给你一个链表数组，每个链表都已经按升序排列。
//
//请你将所有链表合并到一个升序链表中，返回合并后的链表。
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        for (int i = 1; i < lists.length ; i++) {

            lists[0]=merge(lists[0],lists[i]);

        }
        return lists[0];
    }

    //合并两个有序链表
    public ListNode merge(ListNode h1,ListNode h2){

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while(h1!=null&&h2!=null){

            if(h1.val<=h2.val){
                tail.next=h1;
                h1=h1.next;
            }else{
                tail.next=h2;
                h2=h2.next;
            }

            tail=tail.next;
        }

        tail.next=h1==null?h2:h1;

        return dummyHead.next;

    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(4);
        h1.next.next = new ListNode(5);
        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(3);
        h2.next.next = new ListNode(4);
        ListNode h3 = new ListNode(2);
        h3.next = new ListNode(6);

        ListNode[] listNodes = new ListNode[]{h1,h2,h3};
        Solution solution = new Solution();
        ListNode listNode = solution.mergeKLists(listNodes);

    }
}
