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
17    int index = 0;
18    public int kthSmallest(TreeNode root, int k) 
19    {
20        return findKth(root, k);
21        
22    }
23    private int findKth(TreeNode root, int k)
24    {
25        if(root == null)
26            return Integer.MIN_VALUE;
27        if(index == k)
28            return root.val;
29        
30        int left = findKth(root.left,k);
31        if(left == Integer.MIN_VALUE)
32        {
33            this.index++;
34            if(this.index == k)
35                return root.val;
36            return findKth(root.right,k);
37        }
38        else
39        {
40            return left;
41        }
42    }
43
44}