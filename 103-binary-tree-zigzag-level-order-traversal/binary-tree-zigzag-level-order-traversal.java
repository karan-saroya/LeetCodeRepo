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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<TreeNode> currList = new ArrayList<TreeNode>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        currList.add(root);
        int level = 0;

        while(currList.size() != 0)
        {
            List<TreeNode> child = new ArrayList<TreeNode>();
            List<Integer> list= new ArrayList<Integer>();
            while(currList.size() != 0)
            {
                TreeNode node = currList.removeFirst();
               
                if(node != null)
                {
                       // System.out.println("Node val:" + node.val + "Level :" + level);
                        list.add(node.val);
                        
                            //System.out.println("In the first branch");
                            child.add(node.left);
                            child.add(node.right);  
                            //System.out.println(child);    
                        
                       
                }
                
            }

            currList.addAll(child);
            if(!list.isEmpty())
            {
                if(level%2 != 0)
                    Collections.reverse(list);
                    
                    ans.add(list);
            }
                
            level++;
        }
        return ans;

    }
}