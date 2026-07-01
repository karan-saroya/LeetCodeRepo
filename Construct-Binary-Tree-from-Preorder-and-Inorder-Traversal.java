1class Solution {
2   Map<Integer, Integer> valueToInOrder;
3   int[] preorderRep, inorderRep;
4   public TreeNode buildTree(int[] preorder, int[] inorder) 
5   {
6	valueToInOrder = new HashMap<Integer, Integer>();
7	preorderRep = preorder;
8	inorderRep = inorder;
9	for(int i=0;i<inorder.length;i++)
10	{
11		valueToInOrder.put(inorder[i], i);
12	}
13	// 
14	return buildTreeFunc(0, 0,inorder.length-1);
15        
16    }
17  TreeNode buildTreeFunc(int indPO, int startIO, int endIO)
18{
19	if(endIO < startIO)
20		return null;
21	if(indPO >= preorderRep.length)
22		return null;
23	if(indPO < 0)
24		return null;
25	if(startIO > endIO)
26		return null;
27	int rootVal = preorderRep[indPO];
28	int rootIndIO=  valueToInOrder.get(rootVal);
29	TreeNode left = buildTreeFunc( indPO+1, startIO, rootIndIO-1);
30	TreeNode right = buildTreeFunc( indPO + rootIndIO - startIO + 1, rootIndIO+1, endIO);
31	TreeNode currNode = new TreeNode(rootVal, left, right);
32	return currNode;
33}
34
35}
36
37