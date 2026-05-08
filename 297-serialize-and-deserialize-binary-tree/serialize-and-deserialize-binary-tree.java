/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if(root == null)
            return "null";
        String serialized = "";
        serialized += root.val ;
        serialized += ","+serialize(root.left);
        serialized +="," + serialize(root.right);
        return serialized;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data.isEmpty())
            return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(q);
        
    }
    private TreeNode build(Queue<String> q)
    {
        String val = q.poll();
        if(val.equals("null"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = build(q);
        node.right = build(q);
        return node;        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));