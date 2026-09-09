/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode temp=headA;
       HashSet<ListNode> set= new HashSet<>();
       while(temp!=null)
       {
        set.add(temp);
        temp=temp.next;
       }
       ListNode t=headB;
       while(t != null)
       {
        if(set.contains(t))
        {
            return t;
        }
        t=t.next;
       }
       return null;
    }
}