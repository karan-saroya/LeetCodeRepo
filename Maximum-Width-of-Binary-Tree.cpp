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
14    int widthOfBinaryTree(TreeNode* root) 
15    {
16        queue<pair<TreeNode*,long long>> currList;
17        currList.push({root, 0});
18        long long max = 0;
19        while(!currList.empty())
20        {
21            queue<pair<TreeNode *, long long>> children;
22            unsigned long long minIndex = ULLONG_MAX;
23            unsigned long long maxIndex = 0;
24
25            while(!currList.empty())
26            {
27               // cout<<"Inner while"<<endl;
28                pair<TreeNode*, unsigned long long> node = currList.front();
29                TreeNode* currNode = node.first;
30                
31                unsigned long long index = node.second;
32                if(index < minIndex)
33                    minIndex = index;
34                if(index > maxIndex)
35                    maxIndex = index;
36                currList.pop();
37                if(currNode)
38                {
39                    children.push({currNode->left, 2*index});
40                    children.push({currNode->right, 2*index+1});
41
42                }
43                
44            }
45            if(minIndex == ULLONG_MAX || maxIndex == 0)
46            {
47                if(max < 1)
48                    max = 1;
49            }
50            else
51            {
52                if(max < maxIndex - minIndex + 1)
53                    max = maxIndex - minIndex + 1;
54            }
55            while(!children.empty())
56            {
57                pair<TreeNode*,unsigned long long> child= children.front();
58                children.pop();
59                if(child.first)
60                {
61                    currList.push(child);
62                }
63            }
64           
65        }
66        return max;
67    }
68};