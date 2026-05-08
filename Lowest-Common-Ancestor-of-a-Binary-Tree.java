1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10class Solution {
11    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
12    {
13
14        int depthFirst = 0, depthSec = 0;
15        List<TreeNode> pAncestor = find_depth(p, root);
16        List<TreeNode> qAncestor = find_depth(q, root);
17
18        int index = Math.min(pAncestor.size(), qAncestor.size());
19        TreeNode ans = null;
20        for(int i=index-1;i>=0;i--)
21        {
22            if(pAncestor.get(i).val == qAncestor.get(i).val)
23            {
24                ans = pAncestor.get(i);
25                break;
26            }
27        }
28
29        return ans;    
30    }
31    private List<TreeNode> find_depth(TreeNode p, TreeNode root)
32    {   
33        if(root == p)
34        {
35            List<TreeNode> ret = new ArrayList<TreeNode>();
36            ret.add(p);
37            return ret;
38        }
39            
40        if (root == null)
41            return null;
42        List<TreeNode> left = find_depth(p,root.left);
43        List<TreeNode> right = find_depth(p,root.right);
44        if(left != null)
45            {
46                left.addFirst(root);
47                return left;
48            } 
49        else if(right != null)
50        {
51            right.addFirst(root);
52            return right;
53        }
54        else
55        {
56            return null;
57        }
58    }
59}