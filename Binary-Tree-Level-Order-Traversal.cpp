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
14    vector<vector<int>> levelOrder(TreeNode* root) 
15    {
16        vector<vector<int>> ans;
17        
18        if(root == NULL)
19            return ans;
20        queue<TreeNode*> currNodeList;
21        
22        currNodeList.push(root);
23        vector<int> rootVec{root->val};
24        ans.push_back(rootVec);
25        while(!currNodeList.empty())
26        {
27            queue<TreeNode*> children;
28            while(!currNodeList.empty())
29            {
30               TreeNode* nodePtr = currNodeList.front();
31               if(nodePtr)
32               {
33                    if(nodePtr->left)
34                        children.push(nodePtr->left);
35                    if(nodePtr->right)
36                        children.push(nodePtr->right);
37               }
38                
39                currNodeList.pop();
40            }
41            vector<int> childVec;
42            while(!children.empty())
43            {
44                currNodeList.push(children.front());
45                childVec.push_back((children.front())->val);
46                children.pop();
47            }
48            if(!childVec.empty())
49                ans.push_back(childVec);
50
51        }
52
53        return ans;
54    }
55};