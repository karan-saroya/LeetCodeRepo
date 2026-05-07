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
        Map<ListNode, Integer> listMap = new HashMap<ListNode, Integer>();

        ListNode slow=head, fast=head, ans =null;
        boolean hasCycle=false;
        int count= 0;
        while(fast != null)
        {
            if(listMap.containsKey(fast))
            {
                hasCycle = false;
                ans = fast;
                break;
            }
            listMap.put(fast, count++);
            fast = fast.next;
        }

        return ans;
    }
}