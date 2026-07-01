1
2class Solution {
3    
4    Map<TreeNode, Integer> nodeColumnMap;
5    int minColumn=Integer.MAX_VALUE, maxColumn=Integer.MIN_VALUE;
6    Map<Integer, List<Integer>> columnNodeListMap;
7    public List<List<Integer>> verticalOrder(TreeNode root) 
8    {
9	if(root == null)
10		return new ArrayList<List<Integer>>();
11 // Assign column nums 
12	nodeColumnMap = new HashMap<TreeNode, Integer>();
13	columnNodeListMap = new HashMap<Integer, List<Integer>>();
14// Assign columns num to every node!
15	assignColumn(root, 0);
16	for(int i=minColumn;i<=maxColumn;i++)
17	{
18		ArrayList<Integer> nodeList = new ArrayList<Integer>();
19		columnNodeListMap.put(i, nodeList);
20	}
21	levelOrderTraversal(root);
22	List<List<Integer>> answer = new ArrayList<List<Integer>>();
23	for(int i=minColumn;i<=maxColumn;i++)
24	{
25		List<Integer> nodeList = columnNodeListMap.get(i);
26		answer.add(nodeList);
27	}
28	return answer;
29    }
30   void assignColumn(TreeNode currNode, int columnNum)
31   {
32	if(currNode == null)
33		return;
34	if(columnNum < minColumn)   // Min  -> 0
35		minColumn = columnNum;
36	if(columnNum > maxColumn)   // MAx , 
37		maxColumn = columnNum;
38	nodeColumnMap.put(currNode, columnNum);
39	assignColumn(currNode.left, columnNum-1);	
40	assignColumn(currNode.right, columnNum+1);	
41    }
42void levelOrderTraversal(TreeNode root)
43{
44	Queue<TreeNode> currList = new ArrayDeque<TreeNode>();
45	currList.add(root);
46	while(!currList.isEmpty())
47	{
48				
49			TreeNode currNode = currList.remove();
50			int columnNum = nodeColumnMap.get(currNode);
51			columnNodeListMap.get(columnNum).add(currNode.val);
52			TreeNode leftChild = currNode.left, rightChild = currNode.right;
53			if(leftChild != null)
54				currList.add(leftChild);
55			if(rightChild != null)
56				currList.add(rightChild);
57	
58}
59}
60
61}
62