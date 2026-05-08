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
17    int max = Integer.MIN_VALUE;
18    public int maxPathSum(TreeNode root) 
19    {
20        maxGain(root);
21        return this.max;
22    }
23
24    private int maxGain(TreeNode root)
25    {
26        if(root == null)
27            return 0;
28        
29        int leftMaxGain = Math.max(maxGain(root.left),0);
30        int rightMaxGain = Math.max(maxGain(root.right),0);
31
32        if(root.val + leftMaxGain + rightMaxGain > this.max)
33            this.max = root.val + leftMaxGain + rightMaxGain;
34        
35        return root.val + Math.max(leftMaxGain, rightMaxGain);
36
37        
38    }
39}