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
    public ListNode swapPairs(ListNode head) {
       ListNode dummy =  new ListNode();
       dummy.next=head;
       ListNode temp=dummy;
 while(temp.next != null && temp.next.next != null)
 {
    ListNode first=temp.next;
    ListNode sec=temp.next.next;
    first.next=sec.next;
    sec.next=first;
    temp.next=sec;
    temp=first;
 }
 return dummy.next;
    }
}