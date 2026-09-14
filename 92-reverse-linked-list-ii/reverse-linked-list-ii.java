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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode temp=dummy;
        for(int i=1;i<left;i++)
        {
            temp=temp.next;
        }
        ListNode curr=temp.next;
        ListNode safe=curr.next;
        for(int i=0;i<right-left;i++)
        {
            curr.next=safe.next;
            safe.next=temp.next;
            temp.next=safe;
            safe=curr.next;
        }
        return dummy.next;
    }
}