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
14    unordered_map<TreeNode*, long> subTreeSum;
15    int MOD = 1000000007;
16    long total;
17    long answer = LLONG_MIN;
18    int maxProduct(TreeNode* root) 
19    {
20        treeSum(root);
21        total = subTreeSum[root];
22        cout<<total<<endl;
23        mp(root);
24        return (int)(answer%MOD);
25
26    }
27    long treeSum(TreeNode* root)
28    {
29        if(!root)
30            return 0;
31
32        if(subTreeSum.find(root) != subTreeSum.end())
33        {
34            return subTreeSum[root];
35        }
36        long leftSum= treeSum(root->left);
37        long rightSum = treeSum(root->right);
38        subTreeSum[root] = leftSum + rightSum + root->val;
39        return subTreeSum[root];
40    }
41    long mp(TreeNode* root)
42    {
43        
44        if(root == NULL)
45            return 0;
46
47        else if(!root->left && !root->right)
48            return 0;
49        mp(root->left);
50        mp(root->right);
51        if(root)
52            cout<<"Root:"<<root->val<<endl;
53        if(root->left && root->right)
54        {
55            // cout<<"Left Subtree Sum" << subTreeSum[root->left]<<endl;
56            // cout<<"Right Subtree Sum" << subTreeSum[root->right]<<endl;
57            
58            long leftEdgeRemove = (total-subTreeSum[root->left])* (subTreeSum[root->left]);
59            long rightEdgeRemove = (total-subTreeSum[root->right])* (subTreeSum[root->right]);
60            long maxProd = max(leftEdgeRemove, rightEdgeRemove);
61            if(maxProd > answer)
62            {
63                // cout<<"Max Prod :"<< maxProd<<endl;
64                // cout<<"Case 1"<<endl;
65
66                answer = maxProd;
67            }
68            return maxProd;
69        }
70        else
71        {
72            if(root->left)
73            {
74                //  cout<<"Left Subtree Sum" << subTreeSum[root->left]<<endl;
75                long maxProd = (total-subTreeSum[root->left])* (subTreeSum[root->left]);
76                if(maxProd > answer)
77                {// {cout<<"Max Prod :"<< maxProd<<endl;
78                //                 cout<<"Case 2"<<endl;
79
80                    answer = maxProd;
81                }
82                
83                return maxProd;
84
85            }
86            else
87            {
88                // cout<<"Right Subtree Sum" << subTreeSum[root->right]<<endl;
89                long maxProd = (total-subTreeSum[root->right])* (subTreeSum[root->right]);
90                if(maxProd > answer)
91                    {
92                        // cout<<"Max Prod :"<< maxProd<<endl;
93                        //                 cout<<"Case 3"<<endl;
94
95                        answer = maxProd;
96                        
97                
98                    }
99                return maxProd;
100
101            }
102        }
103    }
104
105
106};