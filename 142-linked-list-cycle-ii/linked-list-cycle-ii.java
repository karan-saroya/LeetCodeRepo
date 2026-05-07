/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) 
    {

        ListNode slow = head, fast=head;
        if(head == null)
            return null;
        do
        {
            fast = fast.next;
            if(fast == null)
                break;
            fast = fast.next;
            if( slow == null)
                break;
            slow = slow.next ;
        }while((fast != slow && fast != null && slow != null));
        if(slow == null || fast == null)
            return null;
        slow = head;
        while(fast != slow)
        {
            fast=fast.next;
            slow= slow.next;
        }
        return fast;
    }
}