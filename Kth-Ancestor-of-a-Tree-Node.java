1class TreeAncestor
2{
3	int[][] up;
4	int LOG =30;
5	int[] par;
6	public TreeAncestor(int n, int[] parent) 
7    	{
8		up = new int[n][LOG];
9		par= parent;
10		for(int i=0;i<n;i++)
11			Arrays.fill(up[i], -1);
12		
13		preprocess();
14	}
15	void preprocess()
16	{
17		for(int k=0;k<LOG;k++)
18		{
19			for(int i=0;i<up.length;i++)
20			{
21				if(k == 0)
22					up[i][0] = par[i];
23				else
24				{
25					if(up[i][k-1] == -1)
26						up[i][k] = -1;
27					else
28						{
29							up[i][k] = up[up[i][k-1]][k-1];
30						}
31				}
32			}
33}
34
35}
36
37
38
39
40
41int getKthAncestor(int node, int k)
42{
43	for(int i=0;i<LOG;i++)
44	{
45		if((k>>i & 1) != 0 && node != -1)
46		{
47			node = up[node][i];
48		}
49		else if(node == -1)
50			break;
51	}
52	return node;
53}
54	
55}
56