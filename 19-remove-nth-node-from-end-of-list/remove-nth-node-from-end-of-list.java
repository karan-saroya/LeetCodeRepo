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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        // handle case of 1 node
        if(head.next == null)
            return null;
        ListNode slow, fast;
        fast = head;
        slow = head;    
        for(int i=1;i< n;i++)
        {
            fast = fast.next;
        }

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }
        if(fast.next == null)
        {
            head = slow.next;
            return head;
        }
        slow.next = slow.next.next;
        return head;

    }
}