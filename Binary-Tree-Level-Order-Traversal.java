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
17    public List<List<Integer>> levelOrder(TreeNode root) 
18    {
19        List<TreeNode> childNodeList = new ArrayList<TreeNode>();
20        List<List<Integer>> ans = new ArrayList<List<Integer>>();
21        childNodeList.add(root);
22
23        while(childNodeList.size() != 0)
24        {
25            ArrayList<TreeNode> levelNodeList = new ArrayList<TreeNode>();
26            ArrayList<TreeNode> child = new ArrayList<TreeNode>();
27            while(childNodeList.size() != 0 )
28            {
29                TreeNode node = childNodeList.removeFirst();
30                if(node != null)
31                {
32                    levelNodeList.add(node);
33                    child.add(node.left);
34                    child.add(node.right);
35                }
36            }
37            ArrayList<Integer> list = new ArrayList<Integer>();
38            for(TreeNode node: levelNodeList)
39                list.add(node.val);
40            if(!list.isEmpty())
41                ans.add(list);
42            childNodeList.addAll(child);
43
44        }
45        return ans;
46    } 
47}