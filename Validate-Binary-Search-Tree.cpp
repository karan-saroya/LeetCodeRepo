1/**
2 * Definition for a binary tree node.
3 * struct TreeNode {
4 *     int val;
5 *     TreeNode *left;
6 *     TreeNode *right;
7 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
8 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
9 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
10 * };
11 */
12
13class Solution {
14public:
15    bool is_valid(TreeNode *root, long left, long right)
16    {
17        if(!root)
18            return true;
19        bool retval = root->val > left && root->val < right;
20        return retval && is_valid(root->left, left, root->val) && is_valid(root->right, root->val, right);
21    }
22    bool isValidBST(TreeNode* root) {
23        // run dfs
24        return is_valid(root, LONG_MIN, LONG_MAX);
25        
26    }
27};