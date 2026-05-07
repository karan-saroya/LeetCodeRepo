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
15        Map<ListNode, Integer> listMap = new HashMap<ListNode, Integer>();
16
17        ListNode slow=head, fast=head, ans =null;
18        boolean hasCycle=false;
19        int count= 0;
20        while(fast != null)
21        {
22            if(listMap.containsKey(fast))
23            {
24                hasCycle = false;
25                ans = fast;
26                break;
27            }
28            listMap.put(fast, count++);
29            fast = fast.next;
30        }
31
32        return ans;
33    }
34}