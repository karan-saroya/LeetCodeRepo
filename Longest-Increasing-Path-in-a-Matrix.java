1public class Solution
2{
3	public int longestIncreasingPath(int[][] matrix)
4	{
5
6		int numR=matrix.length, numC = matrix[0].length;
7		Queue<List<Integer>> topoSortQueue = new ArrayDeque<List<Integer>>();
8		int[] inDegree= new int[numR*numC];
9		int[] dist = new int[numR*numC];
10		Arrays.fill(inDegree, 0);
11		Arrays.fill(dist, 0);
12		List<List<Integer>> topoSortList =new ArrayList<List<Integer>>();
13		// fill the inDegree
14		for(int i=0;i<numR;i++)
15		{
16			for(int j=0;j<numC;j++)
17			{
18				int index = getIndex(i, j, numC);
19				inDegree[index] = calcInDeg(i,j,matrix);	
20				if(inDegree[index] == 0)
21				{
22					List<Integer> startList= new ArrayList<Integer>();
23					startList.add(i);
24					startList.add(j);
25					topoSortQueue.add(startList);
26				}
27			}
28		}
29		
30        while(!topoSortQueue.isEmpty())
31        {
32            List<Integer> candList = topoSortQueue.poll();
33            int candX = candList.get(0), candY = candList.get(1);
34            List<List<Integer>> newCandList= reduceInDegree( candX, candY, inDegree, matrix);
35                    while(!newCandList.isEmpty())
36                {
37                    List<Integer> newCand = newCandList.removeFirst();
38                    topoSortQueue.add(newCand);
39                }
40            topoSortList.add(candList);
41
42        }
43		
44        for(List<Integer> currCand: topoSortList)
45        {
46            incrDistNeighbor(currCand.get(0), currCand.get(1), dist, numC, matrix);
47        }
48
49        int maxDist = 0;
50        for(int i=0;i<dist.length;i++)
51        {
52            if(maxDist< dist[i])
53                maxDist = dist[i];
54        }		
55        return maxDist+1;
56}
57
58
59
60
61
62
63
64
65
66
67
68
69
70
71int calcInDeg(int r, int c, int[][] matrix)
72{
73	int inDegree=0;
74	if(r-1>=0 && matrix[r][c] > matrix[r-1][c])
75		inDegree++;
76if(r+1 < matrix.length &&  matrix[r][c] > matrix[r+1][c] )
77	inDegree++;
78if(c-1>=0 && matrix[r][c] > matrix[r][c-1])
79		inDegree++;
80if(c+1 < matrix[0].length &&  matrix[r][c] > matrix[r][c+1] )
81	inDegree++;
82		return inDegree;
83		
84}	
85int getIndex(int r, int c, int numC)
86{
87	return r*numC+c;
88}
89
90List<List<Integer>> reduceInDegree(int r, int c, int[] inDegree, int[][] matrix)
91{
92	List<List<Integer>> newCandList = new ArrayList<List<Integer>>();
93	int numC = matrix[0].length;
94	if(r-1>=0 && matrix[r][c] < matrix[r-1][c])
95		{
96			int index = getIndex(r-1, c,numC);
97			inDegree[index]--;
98			if(inDegree[index] == 0)
99			{
100				List<Integer> cand= new ArrayList<Integer>();
101				cand.add(r-1);
102				cand.add(c);
103				newCandList.add(cand);
104}
105		}
106if(r+1 < matrix.length &&  matrix[r][c] < matrix[r+1][c] )
107{
108			int index = getIndex(r+1, c, numC);
109			inDegree[index]--;
110			if(inDegree[index] == 0)
111			{
112				List<Integer> cand= new ArrayList<Integer>();
113				cand.add(r+1);
114				cand.add(c);
115				newCandList.add(cand);
116}
117		}
118
119if(c-1>=0 && matrix[r][c] < matrix[r][c-1])
120		{
121			int index = getIndex(r, c-1, numC);
122			inDegree[index]--;
123			if(inDegree[index] == 0)
124			{
125				List<Integer> cand= new ArrayList<Integer>();
126				cand.add(r);
127				cand.add(c-1);
128				newCandList.add(cand);
129}
130		}
131
132if(c+1 < matrix[0].length &&  matrix[r][c] < matrix[r][c+1] )
133{
134			int index = getIndex(r, c+1, numC);
135			inDegree[index]--;
136			if(inDegree[index] == 0)
137			{
138				List<Integer> cand= new ArrayList<Integer>();
139				cand.add(r);
140				cand.add(c+1);
141				newCandList.add(cand);
142}
143		}
144
145		return newCandList;
146
147}
148int incrDistNeighbor(int r, int c, int[] dist, int numC, int[][] matrix)
149{
150	int currVal= dist[getIndex(r,c,numC)];
151	if(r-1>=0 && matrix[r][c] < matrix[r-1][c])
152		dist[getIndex(r-1, c,numC)] = currVal+1;
153if(r+1 < matrix.length && matrix[r][c] < matrix[r+1][c] )
154	dist[getIndex(r+1, c, numC)] = currVal+1;
155if(c-1>=0 && matrix[r][c] < matrix[r][c-1])
156		dist[getIndex(r, c-1, numC)] = currVal+1;
157if(c+1 < matrix[0].length && matrix[r][c] < matrix[r][c+1] )
158	dist[getIndex(r, c+1, numC)] = currVal+1;
159
160return 0;
161
162}
163
164
165}
166
167
168
169