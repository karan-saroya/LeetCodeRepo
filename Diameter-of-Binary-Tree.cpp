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
14    int maxPathLength= 0;
15    int diameterOfBinaryTree(TreeNode* root) 
16    {
17        findLongestPath(root);   
18        return maxPathLength;
19    }
20    int findLongestPath(TreeNode* root)
21    {
22        if(root == NULL)
23            return 0;
24        else if(root->left == NULL && root-> right == NULL )
25        {
26            return 0;
27        }
28        int leftTreeMax =0, rightTreeMax=0;
29        if(root->left)
30            leftTreeMax = 1+ findLongestPath(root->left);
31        if(root->right)
32            rightTreeMax = 1+ findLongestPath(root->right);
33        if(leftTreeMax + rightTreeMax> maxPathLength)
34            maxPathLength = leftTreeMax + rightTreeMax;
35        return max(leftTreeMax , rightTreeMax);
36    }
37};