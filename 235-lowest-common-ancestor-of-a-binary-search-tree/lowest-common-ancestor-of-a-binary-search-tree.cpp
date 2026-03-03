/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) 
    {
        if(root == NULL)
            return root;
            //either the root divides the 2
            if( root->val >= min(p->val,q->val) && root->val <= max(q->val, p->val) )
                return root;
            // they both lie to the right side
            else if(root->val < min(p->val,q->val))
                return lowestCommonAncestor(root->right, p, q);
            // they both lie to left side of root
            else
                return lowestCommonAncestor(root->left, p, q);
           
    }
};