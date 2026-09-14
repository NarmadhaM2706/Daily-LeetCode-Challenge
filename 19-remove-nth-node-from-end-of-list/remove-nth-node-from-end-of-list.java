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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode first=dummy;
        ListNode sec=head;
        for(int i=1;i<n;i++)
        {
            sec=sec.next;
        }
        while(sec.next != null)
    {
        first=first.next;
        sec=sec.next;
    }
    first.next=first.next.next;
    return dummy.next;
    }
}