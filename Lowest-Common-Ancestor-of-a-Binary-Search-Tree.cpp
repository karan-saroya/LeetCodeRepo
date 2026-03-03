1/**
2 * Definition for a binary tree node.
3 * struct TreeNode {
4 *     int val;
5 *     TreeNode *left;
6 *     TreeNode *right;
7 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
8 * };
9 */
10
11class Solution {
12public:
13    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) 
14    {
15        if(root == NULL)
16            return root;
17            //either the root divides the 2
18            if( root->val >= min(p->val,q->val) && root->val <= max(q->val, p->val) )
19                return root;
20            // they both lie to the right side
21            else if(root->val < min(p->val,q->val))
22                return lowestCommonAncestor(root->right, p, q);
23            // they both lie to left side of root
24            else
25                return lowestCommonAncestor(root->left, p, q);
26           
27    }
28};