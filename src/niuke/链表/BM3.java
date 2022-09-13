package niuke.链表;

import mianshijingdian.ListNode;

//每k个翻转
public class BM3 {
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        int index = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        boolean flag = false;
        ListNode p = dummy;
        while(head!=null){
            if(index%k==0){
                p.next = reverse(pre,head);
                if(!flag) {
                    flag = !flag;
                }else{
                    p = pre;
                    pre = head;
                }
            }
            head = head.next;
            ++index;
        }

        return dummy.next;
    }
    public ListNode reverse (ListNode head,ListNode pre){
        ListNode cur = head;
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
        BM3 bm3 = new BM3();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        bm3.reverseKGroup(listNode,2);
    }
}
