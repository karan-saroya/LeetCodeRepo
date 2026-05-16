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
12class Solution {
13public:
14    unordered_map<TreeNode*,int> sumMemo;
15    int rob(TreeNode* root) 
16    {
17        return maxBalance(root);
18    }
19    int maxBalance(TreeNode* root)
20    {
21        if(!root)
22            return 0;
23        if(sumMemo.find(root)!= sumMemo.end())
24            return sumMemo[root];
25
26        int inclRoot = root->val;
27        if(root->left)
28            inclRoot += maxBalance(root->left->left) + maxBalance(root->left->right);
29        if(root->right)
30            inclRoot += maxBalance(root->right->left)+ maxBalance(root->right->right);
31
32        inclRoot = max(inclRoot, maxBalance(root->right) + maxBalance(root->left));
33        sumMemo[root] = inclRoot;
34        return sumMemo[root];
35    }
36};