1class Solution {
2    boolean[] visited;
3    int[] low;
4    int[] disc;
5    int timer= 0;
6    List<List<Integer>> critConn;
7    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) 
8    {
9	List<List<Integer>> graph = new ArrayList<List<Integer>>();
10
11	for(int i=0;i<n;i++)
12		graph.add(new ArrayList<Integer>());
13	for(List<Integer> edge : connections)
14	{
15		//Edges must be unique
16		graph.get(edge.get(0)).add(edge.get(1));
17		graph.get(edge.get(1)).add(edge.get(0));
18
19	}
20	
21
22	visited  = new boolean[n];
23	low  = new int[n];
24      	disc = new int[n];
25	Arrays.fill(disc, -1);
26	critConn  = new ArrayList<List<Integer>>();	
27	dfs(0, -1, graph); 
28	Collections.sort(critConn, (a,b) -> { return a.get(0) == b.get(0) ? Integer.compare(a.get(1), b.get(1)) : Integer.compare(a.get(0), b.get(0)) ;});
29	return critConn;
30    }
31   void dfs(int u, int parent, List<List<Integer>> graph)
32    {
33	visited[u] = true;
34	disc[u] = timer;
35	low[u] = timer;
36	timer++;
37	List<Integer> neighbors = graph.get(u);
38	for(int neighbor: neighbors)
39	{	
40		if(neighbor == parent)
41			continue;
42		if(!visited[neighbor])
43		{
44			dfs(neighbor, u, graph);
45			low[u] = Math.min(low[u], low[neighbor]);
46			if(low[neighbor] > disc[u])
47			{
48				List<Integer> bridge = new ArrayList<Integer>();
49				bridge.add(u);
50				bridge.add(neighbor);
51				critConn.add(bridge);
52			}
53			
54		}
55		
56else
57		{
58			low[u] = Math.min(disc[neighbor], low[u]);
59		}
60	}
61     }
62
63}
64