1/**
2 * Definition for singly-linked list.
3 * struct ListNode {
4 *     int val;
5 *     ListNode *next;
6 *     ListNode() : val(0), next(nullptr) {}
7 *     ListNode(int x) : val(x), next(nullptr) {}
8 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
9 * };
10 */
11
12class Solution {
13public:
14    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
15        ListNode *curr1=list1, *curr2 = list2, *prev1= curr1, *prev2= curr2, *head=NULL;
16        if(list1 != NULL && list2 != NULL)
17            {
18                if(list1->val <= list2->val)
19                    head = list1;
20                else
21                    head = list2;
22            }
23        else if (list1 != NULL)
24            return head = list1;
25        else
26            return head = list2; 
27        while(curr1 != NULL and curr2!= NULL)
28        {
29            if(curr1->val <= curr2->val)
30            {
31                prev1 = curr1;
32                while(curr1 != NULL && curr1->val <= curr2->val)
33                {
34                    prev1 = curr1;
35                    curr1=curr1->next;
36                }
37                prev1->next=curr2; 
38                
39            }   
40            else
41            {
42                prev2 = curr2;
43                while(curr2 != NULL &&curr2->val <= curr1->val)
44                {
45                    prev2=curr2;
46                    curr2= curr2->next;
47                }
48                prev2->next = curr1;
49            }
50        }
51        if(curr1 == NULL && curr2 == NULL)
52        {
53            // both are of same size
54            if(prev1->val <= prev2->val)
55            {
56                prev1->next = prev2;
57            }
58            else
59            {
60                prev2->next = prev1;
61            }
62        }
63        else if(curr1 == NULL)
64        {
65            prev1->next = curr2;
66
67        }
68        else
69        {
70            // list2 is ending
71            prev2->next= curr1;
72        }
73        return head;
74    }
75};
76