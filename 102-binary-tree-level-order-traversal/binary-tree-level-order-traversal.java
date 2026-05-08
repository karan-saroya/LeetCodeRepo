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
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<TreeNode> childNodeList = new ArrayList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        childNodeList.add(root);

        while(childNodeList.size() != 0)
        {
            ArrayList<TreeNode> levelNodeList = new ArrayList<TreeNode>();
            ArrayList<TreeNode> child = new ArrayList<TreeNode>();
            while(childNodeList.size() != 0 )
            {
                TreeNode node = childNodeList.removeFirst();
                if(node != null)
                {
                    levelNodeList.add(node);
                    child.add(node.left);
                    child.add(node.right);
                }
            }
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(TreeNode node: levelNodeList)
                list.add(node.val);
            if(!list.isEmpty())
                ans.add(list);
            childNodeList.addAll(child);

        }
        return ans;
    } 
}