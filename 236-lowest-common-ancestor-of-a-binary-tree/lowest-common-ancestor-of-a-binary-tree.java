/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {

        int depthFirst = 0, depthSec = 0;
        List<TreeNode> pAncestor = find_depth(p, root);
        List<TreeNode> qAncestor = find_depth(q, root);

        int index = Math.min(pAncestor.size(), qAncestor.size());
        TreeNode ans = null;
        for(int i=index-1;i>=0;i--)
        {
            if(pAncestor.get(i).val == qAncestor.get(i).val)
            {
                ans = pAncestor.get(i);
                break;
            }
        }

        return ans;    
    }
    private List<TreeNode> find_depth(TreeNode p, TreeNode root)
    {   
        if(root == p)
        {
            List<TreeNode> ret = new ArrayList<TreeNode>();
            ret.add(p);
            return ret;
        }
            
        if (root == null)
            return null;
        List<TreeNode> left = find_depth(p,root.left);
        List<TreeNode> right = find_depth(p,root.right);
        if(left != null)
            {
                left.addFirst(root);
                return left;
            } 
        else if(right != null)
        {
            right.addFirst(root);
            return right;
        }
        else
        {
            return null;
        }
    }
}