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
17    public List<Integer> rightSideView(TreeNode root) {
18        List<Integer> ans = new ArrayList<Integer>();
19        List<TreeNode> currList = new ArrayList<TreeNode>();
20        currList.add(root);
21        while(currList.size() != 0)
22        {
23            List<TreeNode> child = new ArrayList<TreeNode>();
24            List<TreeNode> list = new ArrayList<TreeNode>();
25            while(currList.size() != 0)
26            {
27                TreeNode node = currList.removeFirst();
28                if(node != null)
29                {
30                    list.add(node);
31                    child.add(node.left);
32                    child.add(node.right);
33                }               
34            }
35
36            if(!list.isEmpty())
37            {
38               ans.add(list.getLast().val);
39                   
40            }
41            currList.addAll(child);
42
43        }
44        return ans;
45    }
46}