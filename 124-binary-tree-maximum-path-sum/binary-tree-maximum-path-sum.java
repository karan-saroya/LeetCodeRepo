/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) 
    {
        maxGain(root);
        return this.max;
    }

    private int maxGain(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int leftMaxGain = Math.max(maxGain(root.left),0);
        int rightMaxGain = Math.max(maxGain(root.right),0);

        if(root.val + leftMaxGain + rightMaxGain > this.max)
            this.max = root.val + leftMaxGain + rightMaxGain;
        
        return root.val + Math.max(leftMaxGain, rightMaxGain);

        
    }
}