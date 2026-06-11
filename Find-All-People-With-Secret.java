1
2class Solution {
3    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) 
4   {
5	DSU dsu= new DSU(n);
6	Arrays.sort(meetings, (a,b) -> Integer.compare(a[2], b[2]));
7	dsu.setKnowsSecret(0);
8	dsu._union(0, firstPerson);
9	
10	for(int i=0;i<meetings.length;)
11	{
12		List<int[]> meetingsPerSlot= new ArrayList<int[]>();
13		int currTime= meetings[i][2];
14		meetingsPerSlot.add(meetings[i]);
15		i++;
16		while(i < meetings.length && meetings[i][2] == currTime)
17		{
18			meetingsPerSlot.add(meetings[i]);
19			i++;
20		}
21		for(int[] meeting: meetingsPerSlot)
22		{
23//Case 1 - both in the knows set
24// case 2: both in does not know set
25// case 3: only one knows 
26			dsu._union(meeting[0], meeting[1]);
27		}
28		for(int[] meeting: meetingsPerSlot)
29		{
30			int source= meeting[0];
31			int dest = meeting[1];			
32if(!dsu.doesKnowSecret(source) && !dsu.doesKnowSecret(dest))
33{
34	dsu.resetNode(source);
35	dsu.resetNode(dest);
36}
37                         }
38	
39		
40	}
41        return dsu.knowsSecretList();
42    }
43}
44
45class DSU
46{
47	int[] parent;
48	int[] rank;
49	boolean[] knowsSecret;
50	public DSU(int n)
51	{
52		parent = new int[n];
53		rank = new int[n];
54		knowsSecret= new boolean[n];
55		Arrays.fill(rank, 0);
56		Arrays.fill(knowsSecret, false);
57		for(int i=0;i<n;i++)
58			parent[i]=i;
59	}
60	int find(int x)
61	{
62		if(parent[x]!=x)
63			parent[x]= find(parent[x]);
64		return parent[x];
65}
66int _union(int x, int y)
67{
68	int px = find(x), py=find(y);
69	if(px == py)
70		return -1;
71	if(rank[px]> rank[py])
72	{
73		parent[py]= px;
74		if(knowsSecret[py] || knowsSecret[px])
75		{
76			knowsSecret[px]= true;
77		}
78	}
79	else if(rank[px]< rank[py])
80	{
81		parent[px]= py;
82		if(knowsSecret[py] || knowsSecret[px])
83		{
84			knowsSecret[py]= true;
85		}
86
87	}
88	else
89	{
90		rank[px]++;
91		parent[py]= px;
92		if(knowsSecret[py] || knowsSecret[px])
93		{
94			knowsSecret[px]= true;
95		}
96
97	}
98    return 0;
99}
100boolean doesKnowSecret(int x)
101{
102	return knowsSecret[find(x)];
103}
104List<Integer> knowsSecretList()
105{
106	List<Integer> answer = new ArrayList<Integer>();
107	for(int i=0;i<knowsSecret.length;i++)
108	{
109		if(knowsSecret[find(i)])
110			answer.add(i);
111	}
112	return answer;
113}
114void resetNode(int x)
115{
116    rank[x]= 0;
117	parent[x]=x;
118}
119void setKnowsSecret(int x)
120{
121	knowsSecret[find(x)]= true;
122}
123}
124