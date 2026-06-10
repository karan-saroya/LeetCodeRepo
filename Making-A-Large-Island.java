1
2public class Solution
3{
4	
5	int[][] graph;
6    public int largestIsland(int[][] grid)
7    {
8		int n = grid.length;
9		graph = new int[n][n];
10		List<int[]> positions= new ArrayList<int[]>();
11		for(int i=0;i<n;i++)
12		{
13			Arrays.fill(graph[i], 0);
14		}
15		for(int i=0;i<n;i++)
16		{
17			for(int j=0;j<n;j++)
18			{
19				if(grid[i][j] == 1)
20				{
21					positions.add(new int[]{i,j});
22				}
23			}
24			
25		}
26		DSU dsu = new DSU(n);
27		for(int i=0;i<positions.size();i++)
28		{
29			int[] currNode = positions.get(i);
30			int currX = currNode[0], currY = currNode[1];
31			int currIndex = getIndex(currX, currY, n);
32			graph[currX][currY] = 1;
33			int upInd=-1, downInd=-1, leftInd= -1, rightInd =-1;
34			if(currX-1 >=0 && graph[currX-1][currY] == 1)
35			{
36				upInd = getIndex(currX-1, currY,n);
37				dsu._union(currIndex, upInd);
38			}
39
40			
41			if(currX+1 < n && graph[currX+1][currY] == 1)
42			{
43				downInd = getIndex(currX+1, currY,n);
44				dsu._union(currIndex, downInd);
45			}
46			if(currY-1 >=0 && graph[currX][currY-1] == 1)
47			{
48				leftInd = getIndex(currX, currY-1,n);
49				dsu._union(currIndex, leftInd);
50			}
51			if(currY+1 < n && graph[currX][currY+1] == 1)
52			{
53				rightInd = getIndex(currX, currY+1,n);
54				dsu._union(currIndex, rightInd);
55			}
56
57
58	
59		}
60
61		//current sizes preprocessed!
62		int sizeLargestIsland=0;
63        for(int i = 0; i < n*n; i++) 
64            sizeLargestIsland = Math.max(sizeLargestIsland, dsu.getSize(dsu.find(i)));
65		for(int i=0;i<n;i++)
66		{
67			for(int j=0;j<n;j++)
68			{
69				if(graph[i][j] == 0)
70				{
71					int currX =i, currY = j;
72			        int currIndex = getIndex(currX, currY, n);
73
74					int size=1;
75					HashSet<Integer> seen = new HashSet<Integer>();
76                    if(currX-1 >=0 && graph[currX-1][currY] == 1)
77                    {
78                        int upInd = getIndex(currX-1, currY,n);
79                        int root= dsu.find(upInd);
80                        if(!seen.contains(root))
81                        {
82                            seen.add(root);
83                            size+=dsu.getSize(upInd);
84                        }
85                    }
86
87                    
88                    if(currX+1 < n && graph[currX+1][currY] == 1)
89                    {
90                        int downInd = getIndex(currX+1, currY,n);
91                        int root= dsu.find(downInd);
92                        if(!seen.contains(root))
93                        {
94                            seen.add(root);
95                            size+=dsu.getSize(downInd);
96                        }
97                    }
98                    if(currY-1 >=0 && graph[currX][currY-1] == 1)
99                    {
100                        int leftInd = getIndex(currX, currY-1,n);
101                        int root= dsu.find(leftInd);
102                        if(!seen.contains(root))
103                        {
104                            seen.add(root);
105                            size+=dsu.getSize(leftInd);
106                        }
107
108                    }
109                    if(currY+1 < n && graph[currX][currY+1] == 1)
110                    {
111                        int rightInd = getIndex(currX, currY+1,n);
112                        int root= dsu.find(rightInd);
113                        if(!seen.contains(root))
114                        {
115                            seen.add(root);
116                            size+=dsu.getSize(rightInd);
117                        }
118                    }
119            
120                    if(size > sizeLargestIsland)
121                        sizeLargestIsland = size;
122	            }
123            }
124		}
125		return sizeLargestIsland;
126
127    }
128    int getIndex(int r, int c,int n)
129    {
130	    return n*r+c;
131    }
132
133}
134
135class DSU
136{
137	int[] parent;
138	int[] rank;
139	int[] size;
140	public DSU(int n)
141{
142parent = new int[n*n];	
143rank = new int[n*n];
144size=new int[n*n];
145Arrays.fill(size, 1);
146Arrays.fill(rank, 0);
147for(int i=0;i<n*n;i++)
148	parent[i] = i;
149	}
150	int find(int x)
151{
152
153	if(parent[x]!=x)
154	{
155		parent[x]= find(parent[x]);
156	}
157return parent[x];
158}
159
160int _union(int x, int y)
161{
162	int px = find(x), py= find(y);
163	if(px == py)
164		return -1;
165	if(rank[px]> rank[py])
166	{
167		size[px]+=size[py];
168		parent[py] = px;
169}
170else if(rank[px] < rank[py])
171{
172	size[py] +=size[px];
173	parent[px] = py;
174}
175else
176{
177	size[px]+= size[py];
178	rank[px]++;
179	parent[py] = px;
180}
181    return 0;
182}
183int getSize(int index)
184{
185	return size[find(index)];
186}
187}
188
189
190