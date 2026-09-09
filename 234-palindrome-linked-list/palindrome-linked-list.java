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
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode current=head;
        while(current != null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow= head;
        ListNode fast=head.next;
        while(fast != null && fast.next != null)
        {
            slow= slow.next;
            fast = fast.next.next;
        }
        ListNode rev=reverse(slow.next);
        slow.next = null;
        while(rev != null)
        {
            if(rev.val != head.val)
            {
                return false;
            }
            head=head.next;
            rev = rev.next;
        }
        return true;
    }
}