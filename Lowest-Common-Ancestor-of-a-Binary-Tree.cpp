1/**
2 * Definition for a binary tree node.
3 * struct TreeNode {
4 *     int val;
5 *     TreeNode *left;
6 *     TreeNode *right;
7 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
8 * };
9 */
10class Solution {
11public:
12    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) 
13    {
14        return lca(root, p ,q);
15        
16    }
17    TreeNode* lca(TreeNode* root, TreeNode* p, TreeNode* q)
18    {
19        if(root == NULL || root == p || root == q)
20            return root;
21        
22        TreeNode *left = lca(root->left, p ,q);
23        TreeNode *right = lca(root->right, p, q);
24        if(left && right)
25            return root;
26        else
27        {
28            return left ? left:right;
29        }
30    }
31};