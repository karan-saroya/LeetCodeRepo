1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    int ans = 0;
18    public int maxSumBST(TreeNode root) 
19    {
20        bstSum(root);
21        return ans;
22    }
23    public List<Integer> bstSum(TreeNode root)
24    {
25        List<Integer> retList = new ArrayList<Integer>();
26        if(root == null)
27        {
28            retList.add(0); // isBst
29            retList.add(0); // min vale
30            retList.add(0); // max value
31            retList.add(0); // sum Bst
32            
33        }
34        else if(root.right == null && root.left == null)
35        {
36            retList.add(1);
37            retList.add(root.val);
38            retList.add(root.val);
39            retList.add(root.val);
40            if(root.val > ans)
41                ans = root.val;
42        }
43        else
44        {
45            List<Integer> rightList = bstSum(root.right);
46            List<Integer> leftList = bstSum(root.left);
47            int isLeftBst = leftList.get(0);
48            int isRightBst = rightList.get(0);
49            int leftMin = leftList.get(1);
50            int rightMin = rightList.get(1);
51            int leftMax = leftList.get(2);
52            int rightMax = rightList.get(2);
53            int leftSum = leftList.get(3);
54            int rightSum = rightList.get(3);
55
56            if(root.right == null)
57            {
58                if(isLeftBst == 1)
59                {
60                    if(root.val > leftMax)
61                    {
62                        retList.add(1);
63                        retList.add(leftMin);
64                        retList.add(root.val);
65                        retList.add(root.val + leftSum);
66                        if(root.val + leftSum > ans)
67                            ans = root.val + leftSum;
68                    }
69                    else
70                    {
71                        retList.add(0);
72                        retList.add(Math.min(leftMin,root.val));
73                        retList.add(leftMax);
74                        retList.add(root.val + leftSum);
75                    }
76                }
77                else
78                {
79                        retList.add(0);
80                        retList.add(Math.min(leftMin,root.val));
81                        retList.add(leftMax);
82                        retList.add(root.val + leftSum);
83                }
84
85            }
86            else if(root.left == null)
87            {
88                 if(isRightBst == 1)
89                {
90                    if(root.val < rightMin)
91                    {
92                        retList.add(1);
93                        retList.add(root.val);
94                        retList.add(rightMax);
95                        retList.add(root.val + rightSum);
96                        if(root.val + rightSum > ans)
97                            ans = root.val + rightSum ;
98                    }
99                    else
100                    {
101                        retList.add(0);
102                        retList.add(rightMin);
103                        retList.add(Math.max(rightMax, root.val));
104                        retList.add(root.val + rightSum);
105                    }
106                }
107                else
108                {
109                        retList.add(0);
110                        retList.add(rightMin);
111                        retList.add(Math.max(rightMax, root.val));
112                        retList.add(root.val + rightSum);
113                }
114            }
115            else
116            {
117                if(isLeftBst == 1 && isRightBst == 1)
118                {
119                    if(root.val > leftMax && root.val < rightMin)
120                    {
121                        retList.add(1);
122                        retList.add(leftMin);
123                        retList.add(rightMax);
124                        retList.add(root.val + rightSum + leftSum);
125                        if(root.val + rightSum + leftSum > ans)
126                            ans = root.val + rightSum + leftSum;
127                    }
128                    else
129                    {
130                        retList.add(0);
131                        retList.add(Math.min(leftMin,(Math.min(rightMin, root.val))));
132                        retList.add(Math.max(rightMax, Math.max(leftMax, root.val)));
133                        retList.add(root.val + rightSum + leftSum);
134                        
135                    }
136                }
137                else
138                {
139                        retList.add(0);
140                        retList.add(Math.min(leftMin,(Math.min(rightMin, root.val))));
141                        retList.add(Math.max(rightMax, Math.max(leftMax, root.val)));
142                        retList.add(root.val + rightSum + leftSum);
143                }
144
145            }
146        }
147        return retList;
148    }
149
150
151}