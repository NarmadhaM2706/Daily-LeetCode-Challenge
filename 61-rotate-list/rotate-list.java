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
    public ListNode rotateRight(ListNode head, int k) {
        int n=0;
        ListNode temp=head;
        if(head == null) return head;
        while(temp != null)
        {
            n++;
            temp=temp.next;
        }
        k=k%n;
        if(k==0) return head;
        while(k-- != 0)
        {
            temp=head;
            while(temp.next.next != null)
            {
                temp=temp.next;
            }
            ListNode safe=temp.next;
            temp.next=null;
            safe.next=head;
            head=safe;
        }
        return head;
    }
}