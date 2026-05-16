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
14    unordered_map<long, int> prefixSumCount;
15    int ways=0;
16    int pathSum(TreeNode* root, int targetSum) 
17    {
18        prefixSumCount[0]= 1;
19        numWays(0, root,targetSum);
20        return ways;
21    }
22    void numWays(long prefixSum, TreeNode* root, int targetSum)
23    {
24        if(!root)
25            return;
26        prefixSum +=root->val;
27       
28        ways+= prefixSumCount[prefixSum-targetSum];
29        prefixSumCount[prefixSum]++;
30        numWays(prefixSum, root->left,targetSum);
31        numWays(prefixSum, root->right, targetSum);
32        prefixSumCount[prefixSum]--;
33    }
34    
35};