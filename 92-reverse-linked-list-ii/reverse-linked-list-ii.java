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
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        if(head==null || left== right)
        {
            return head;
        }
        for(int i= 1;i<left;i++)
        {
            prev=prev.next;
        }
        ListNode curr=prev.next;
        ListNode temp=curr.next;
       for(int i=0;i<right-left;i++)
        {
            curr.next=temp.next;
            temp.next=prev.next;
            prev.next=temp;
            temp=curr.next;
        }
        return dummy.next;
    }
}