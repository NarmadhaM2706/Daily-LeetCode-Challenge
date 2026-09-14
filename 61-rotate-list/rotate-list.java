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
        ListNode temp=head;
        int cnt=0;
        if(head == null)
        {
            return head;
        }
        while(temp != null)
        {
            cnt++;
            temp=temp.next;
        }
        k=k%cnt;
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