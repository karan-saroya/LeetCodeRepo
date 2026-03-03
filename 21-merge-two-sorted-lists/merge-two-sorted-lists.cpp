/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode *curr1=list1, *curr2 = list2, *prev1= curr1, *prev2= curr2, *head=NULL;
        if(list1 != NULL && list2 != NULL)
            {
                if(list1->val <= list2->val)
                    head = list1;
                else
                    head = list2;
            }
        else if (list1 != NULL)
            return head = list1;
        else
            return head = list2; 
        while(curr1 != NULL and curr2!= NULL)
        {
            if(curr1->val <= curr2->val)
            {
                prev1 = curr1;
                while(curr1 != NULL && curr1->val <= curr2->val)
                {
                    prev1 = curr1;
                    curr1=curr1->next;
                }
                prev1->next=curr2; 
                
            }   
            else
            {
                prev2 = curr2;
                while(curr2 != NULL &&curr2->val <= curr1->val)
                {
                    prev2=curr2;
                    curr2= curr2->next;
                }
                prev2->next = curr1;
            }
        }
        if(curr1 == NULL && curr2 == NULL)
        {
            // both are of same size
            if(prev1->val <= prev2->val)
            {
                prev1->next = prev2;
            }
            else
            {
                prev2->next = prev1;
            }
        }
        else if(curr1 == NULL)
        {
            prev1->next = curr2;

        }
        else
        {
            // list2 is ending
            prev2->next= curr1;
        }
        return head;
    }
};
