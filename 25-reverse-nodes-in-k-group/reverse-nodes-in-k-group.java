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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=head;
        int cnt=0;int c=0;
        while(temp != null && cnt != k)
        {
            cnt++;
            temp=temp.next;
        }
        if(cnt<k) return curr;
        while(curr != null && c != k)
        {
            ListNode safe=curr.next;
            curr.next=prev;
            prev=curr;
            curr=safe;
            c++;
        }
        head.next=reverseKGroup(curr,k);
        return prev;
    }
    
}