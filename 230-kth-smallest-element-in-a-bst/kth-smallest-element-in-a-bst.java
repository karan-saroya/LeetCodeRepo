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
    int index = 0;
    public int kthSmallest(TreeNode root, int k) 
    {
        return findKth(root, k);
        
    }
    private int findKth(TreeNode root, int k)
    {
        if(root == null)
            return Integer.MIN_VALUE;
        if(index == k)
            return root.val;
        
        int left = findKth(root.left,k);
        if(left == Integer.MIN_VALUE)
        {
            this.index++;
            if(this.index == k)
                return root.val;
            return findKth(root.right,k);
        }
        else
        {
            return left;
        }
    }

}