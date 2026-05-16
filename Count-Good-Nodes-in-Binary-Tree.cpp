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
13    int count=0;
14public:
15    int goodNodes(TreeNode* root) {
16        
17        goodNodeCount(root, INT_MIN);
18
19        return count;
20    }
21    void goodNodeCount(TreeNode * root, int maxSeen)
22    {
23        if(!root)
24            return;
25        
26        else
27        {
28            if(root->val >= maxSeen)
29                count++;
30            goodNodeCount(root->left, max(maxSeen, root->val));
31            goodNodeCount(root->right, max(maxSeen, root->val));
32        }
33    }
34
35
36};