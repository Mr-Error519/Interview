package mianshijingdian.e0206;

import java.util.ArrayList;

//编写一个函数，检查输入的链表是否是回文的
//回文:正序倒序都一样
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        while (head!=null){
            listNodes.add(head);
            head = head.next;
        }
        int j =listNodes.size()-1 ;
        int i = 0;
        while (i<j){
            if(listNodes.get(i).val != listNodes.get(j).val){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome1(ListNode head){
        /*
        1 找到前半部分链表的尾节点。
        2 反转后半部分链表。
        3 判断是否回文。
         */
        //1 找到前半部分链表的尾节点。
        ListNode endoffirsthalf = endOfFirstHalf(head);
        //2 反转后半部分链表。
        ListNode p1 = reverseList(endoffirsthalf);
        //3 判断。
        while (p1!=null){
            if(p1.val!=head.val){
                return false;
            }
            p1 = p1.next;
            head = head.next;
        }

    return true;
    }
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
    //快慢指针，快指针走两步，慢指针走一步
    public ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        head.next = l1;
        l1.next = l2;
        Solution solution = new Solution();
        if(solution.isPalindrome(head)){
            System.out.println("true");
            return;
        }
        System.out.println("false");
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
