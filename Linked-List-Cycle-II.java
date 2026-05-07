1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode detectCycle(ListNode head) 
14    {
15
16        ListNode slow = head, fast=head;
17        if(head == null)
18            return null;
19        do
20        {
21            fast = fast.next;
22            if(fast == null)
23                break;
24            fast = fast.next;
25            if( slow == null)
26                break;
27            slow = slow.next ;
28        }while((fast != slow && fast != null && slow != null));
29        if(slow == null || fast == null)
30            return null;
31        slow = head;
32        while(fast != slow)
33        {
34            fast=fast.next;
35            slow= slow.next;
36        }
37        return fast;
38    }
39}