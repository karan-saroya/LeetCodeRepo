1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode(int x) { val = x; }
8 * }
9 */
10public class Codec {
11
12    // Encodes a tree to a single string.
13    public String serialize(TreeNode root) 
14    {
15        if(root == null)
16            return "null";
17        String serialized = "";
18        serialized += root.val ;
19        serialized += ","+serialize(root.left);
20        serialized +="," + serialize(root.right);
21        return serialized;
22        
23    }
24
25    // Decodes your encoded data to tree.
26    public TreeNode deserialize(String data) 
27    {
28        if(data.isEmpty())
29            return null;
30        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
31        return build(q);
32        
33    }
34    private TreeNode build(Queue<String> q)
35    {
36        String val = q.poll();
37        if(val.equals("null"))
38            return null;
39        TreeNode node = new TreeNode(Integer.parseInt(val));
40        node.left = build(q);
41        node.right = build(q);
42        return node;        
43    }
44}
45
46// Your Codec object will be instantiated and called as such:
47// Codec ser = new Codec();
48// Codec deser = new Codec();
49// TreeNode ans = deser.deserialize(ser.serialize(root));