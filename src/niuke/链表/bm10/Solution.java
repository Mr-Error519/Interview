package niuke.链表.bm10;

import mianshijingdian.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode h1 = pHead1;
        ListNode h2 = pHead2;
        List<String> list = new ArrayList<>();
        while(pHead1!=null||pHead2!=null){
            if(pHead1!=null){
                pHead1 = pHead1.next;
                ++len1;
            }
            if(pHead2!=null){
                pHead2 = pHead2.next;
                ++len2;
            }
        }
        ListNode temp = len1>len2?h1:h2;
        ListNode temp2 = len1>len2?h2:h1;
        for(int i=0;i<Math.abs(len1-len2);++i){
            temp = temp.next;
        }
        while(temp!=null){
            if(temp==temp2) return temp;
            temp = temp.next;
            temp2 = temp2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        h1.next = l2;
        l2.next = l3;
        l3.next = l6;
        l6.next = l7;
        h4.next = l5;
        l5.next = l6;
        Solution solution = new Solution();
        solution.FindFirstCommonNode(h1,h4);

    }
}
