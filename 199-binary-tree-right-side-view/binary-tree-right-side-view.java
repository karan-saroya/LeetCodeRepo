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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        List<TreeNode> currList = new ArrayList<TreeNode>();
        currList.add(root);
        while(currList.size() != 0)
        {
            List<TreeNode> child = new ArrayList<TreeNode>();
            List<TreeNode> list = new ArrayList<TreeNode>();
            while(currList.size() != 0)
            {
                TreeNode node = currList.removeFirst();
                if(node != null)
                {
                    list.add(node);
                    child.add(node.left);
                    child.add(node.right);
                }               
            }

            if(!list.isEmpty())
            {
               ans.add(list.getLast().val);
                   
            }
            currList.addAll(child);

        }
        return ans;
    }
}