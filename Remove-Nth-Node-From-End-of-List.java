1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode removeNthFromEnd(ListNode head, int n) 
13    {
14        // handle case of 1 node
15        if(head.next == null)
16            return null;
17        ListNode slow, fast;
18        fast = head;
19        slow = head;    
20        for(int i=1;i< n;i++)
21        {
22            fast = fast.next;
23        }
24
25        while(fast.next != null && fast.next.next != null)
26        {
27            slow = slow.next;
28            fast = fast.next;
29        }
30        if(fast.next == null)
31        {
32            head = slow.next;
33            return head;
34        }
35        slow.next = slow.next.next;
36        return head;
37
38    }
39}