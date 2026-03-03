/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:
    bool is_valid(TreeNode *root, long left, long right)
    {
        if(!root)
            return true;
        bool retval = root->val > left && root->val < right;
        return retval && is_valid(root->left, left, root->val) && is_valid(root->right, root->val, right);
    }
    bool isValidBST(TreeNode* root) {
        // run dfs
        return is_valid(root, LONG_MIN, LONG_MAX);
        
    }
};