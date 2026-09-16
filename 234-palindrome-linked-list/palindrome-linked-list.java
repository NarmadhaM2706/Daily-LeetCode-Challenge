/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        ListNode curr=head;
        while(curr != slow)
        {
            ListNode safe=curr.next;
            curr.next=prev;
            prev=curr;
            curr=safe;
        }
        if(fast != null)
        {
            slow=slow.next;
        }
        ListNode  p1=prev;
        ListNode p2=slow;
        while(p2 != null)
        {
            if(p1.val != p2.val)
            {
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return true;
    }
}