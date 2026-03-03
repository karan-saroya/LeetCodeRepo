1/**
2 * Definition for singly-linked list.
3 * struct ListNode {
4 *     int val;
5 *     ListNode *next;
6 *     ListNode(int x) : val(x), next(NULL) {}
7 * };
8 */
9class Solution {
10public:
11    bool hasCycle(ListNode *head) {
12        ListNode *slow, *fast;
13        if(!head)
14            return false;
15        slow = head;
16        fast = head->next;
17        while(slow != fast && slow != NULL && fast!= NULL)
18        {
19            slow= slow->next;
20            if (fast->next != NULL)
21                fast=(fast->next)->next;
22            else
23            {
24                fast= NULL;
25                break;
26            }
27        } 
28        if(slow == NULL || fast == NULL)
29            return false;
30        return true;
31        
32    }
33};