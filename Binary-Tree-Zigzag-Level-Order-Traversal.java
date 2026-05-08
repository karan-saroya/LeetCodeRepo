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
17    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
18
19        List<TreeNode> currList = new ArrayList<TreeNode>();
20        List<List<Integer>> ans = new ArrayList<List<Integer>>();
21
22        currList.add(root);
23        int level = 0;
24
25        while(currList.size() != 0)
26        {
27            List<TreeNode> child = new ArrayList<TreeNode>();
28            List<Integer> list= new ArrayList<Integer>();
29            while(currList.size() != 0)
30            {
31                TreeNode node = currList.removeFirst();
32               
33                if(node != null)
34                {
35                       // System.out.println("Node val:" + node.val + "Level :" + level);
36                        list.add(node.val);
37                        
38                            //System.out.println("In the first branch");
39                            child.add(node.left);
40                            child.add(node.right);  
41                            System.out.println(child);    
42                        
43                       
44                }
45                
46            }
47
48            currList.addAll(child);
49            if(!list.isEmpty())
50            {
51                if(level%2 != 0)
52                    Collections.reverse(list);
53                    
54                    ans.add(list);
55            }
56                
57            level++;
58        }
59        return ans;
60
61    }
62}