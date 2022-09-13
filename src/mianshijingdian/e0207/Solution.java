package mianshijingdian.e0207;

//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
//不改变链表结构
public class Solution {
    //交点一定不会出现在较长链表前半部分(lenA-lenB),因为会出现相交之后A链表最后有多余结点。
    //先移动较长的链表头结点，对齐较短的链表后一起开始移动
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int lena = 0;
        int lenb = 0;
        while (p1!=null){
            lena++;
            p1 = p1.next;
        }
        while (p2!=null){
            lenb++;
            p2 = p2.next;
        }
        if(lena>lenb){
            for (int i = 0; i <lena-lenb ; i++) {
                headA = headA.next;
            }
            while (headA!=null){
                if(headA==headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }else {
            for (int j = 0; j <lenb-lena ; j++) {
                headB = headB.next;
            }
            while (headB!=null){
                if(headA==headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }
    }


}
