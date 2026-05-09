1class Solution {
2    public int minCostConnectPoints(int[][] points) 
3    {
4        List<int[]> edges = new ArrayList<int[]>();
5        for(int i=0;i<points.length;i++)
6        {
7            for(int j=i+1;j<points.length;j++)
8            {
9                int dist =(int) Math.abs(points[i][0] - points[j][0]) + (int)Math.abs(points[i][1] - points[j][1]);
10                edges.add(new int[]{i, j, dist});
11            }
12
13        }
14
15        edges.sort((a,b) -> Integer.compare(a[2], b[2]));
16        DSU dsu = new DSU(points.length);
17        int cost = 0;
18        int num_edges = 0;
19        for(int[] edge : edges)
20        {
21
22            if(dsu.union(edge[0], edge[1]))
23            {
24                num_edges++;
25                cost+= edge[2];
26            }
27            if(num_edges == points.length-1)
28                break;
29        } 
30        return cost;
31    }
32}
33class DSU
34{
35    int[] parent;
36    int[] rank;
37
38    DSU(int n)
39    {
40        parent = new int[n];
41        rank = new int [n];
42        for(int i=0;i<n ;i++) parent[i] = i;
43
44
45    }
46    int find(int x)
47    {
48        if(parent[x]!= x)
49            parent[x] = find(parent[x]);
50        return parent[x];
51    }
52
53    boolean union(int x, int y)
54    {   
55        int px = find(x) , py = find(y);
56        if(px == py)
57            return false;
58
59        if(rank[px] > rank[py])
60            parent[py] = px;
61        else if( rank[py] > rank[px])
62        {
63            parent[px] = py;
64        }
65        else
66        {
67            parent[py] = px;
68            rank[px]++;
69        }
70        return true;
71    }   
72
73
74
75}