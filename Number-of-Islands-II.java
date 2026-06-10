1public class Solution
2{
3	int[][] graph;
4	public List<Integer> numIslands2(int m, int n, int[][] positions)
5{
6	graph = new int[m][n];
7	for(int i=0;i<m;i++)
8	{
9		Arrays.fill(graph[i], 0);
10	}
11	DSU dsu = new DSU(m,n);
12	int count=0;
13	List<Integer> answers= new ArrayList<Integer>();
14	for(int i=0;i<positions.length;i++)
15	{
16		int currX = positions[i][0], currY = positions[i][1];
17		
18		if(graph[currX][currY] == 1)
19		{
20			answers.add(count);
21			continue;
22		}
23		int currIndex = getIndex(positions[i][0], positions[i][1], n);
24		graph[currX][currY] =1;	
25		int leftIndex =-1, rightIndex=-1, upIndex=-1, downIndex = -1;
26		int mergeCount=0;	
27		if(currX -1 >=0 && graph[currX-1][currY] == 1)
28		{
29			upIndex = getIndex(currX-1, currY,n);
30			if(dsu._union(currIndex, upIndex) != -1)
31			{
32				mergeCount++;
33
34			}
35					}
36		if(currX +1<m && graph[currX+1][currY] == 1)
37		{
38			downIndex = getIndex(currX+1, currY,n);
39if(dsu._union(currIndex, downIndex) != -1)
40			{
41				mergeCount++;
42
43			}
44			
45		}
46if(currY -1 >=0 && graph[currX][currY-1] == 1)
47		{
48			leftIndex = getIndex(currX, currY-1,n);
49			if(dsu._union(currIndex, leftIndex) != -1)
50			{
51				mergeCount++;
52
53			}
54			
55
56		}
57		if(currY+1 < n && graph[currX][currY+1] == 1)
58		{
59			rightIndex = getIndex(currX, currY+1,n);
60			if(dsu._union(currIndex, rightIndex) != -1)
61			{
62				mergeCount++;
63
64			}
65					}
66		mergeCount--;
67		if(mergeCount == -1)
68			count++;
69		else
70		{
71			count = count - mergeCount;
72		}
73		answers.add(count);
74		
75	}
76	return answers;
77
78}
79int getIndex(int r, int c, int m)
80{
81	return r*m+c;
82}
83
84}
85
86class DSU
87{
88	int[] parent;
89	int[] rank;
90public DSU(int m, int n)
91{
92	parent = new int[m*n];
93	rank = new int[m*n];
94	Arrays.fill(rank, 0);
95	for(int i=0;i<m*n;i++)
96		parent[i] = i;
97}
98int find(int x)
99{
100	if(parent[x] != x)
101	{
102		parent[x] = find(parent[x]);
103	}
104	return parent[x];
105}
106int _union(int x, int y)
107{
108	int px = find(x), py = find(y);
109	if(px == py)
110		return -1;
111	if(rank[px] > rank[py])
112		parent[py] = px;
113	else if(rank[px] < rank[py])
114		parent[px] = py;
115		else
116		{
117			parent[py] = px;
118			rank[px]++;
119		}
120return 0; 
121}
122
123
124}
125
126
127