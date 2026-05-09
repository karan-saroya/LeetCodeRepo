1class Solution {
2    public boolean validTree(int n, int[][] edges) 
3    {
4        if(edges.length != n-1)
5            return false;
6        DSU dsu = new DSU(n);
7        for(int i=0;i<edges.length;i++)
8        {
9            dsu.union(edges[i][0], edges[i][1]);
10        }
11
12        if(dsu.numComps() == 1)
13            return true;
14
15
16        return false;
17
18        
19        
20    }
21}
22
23class DSU
24{
25    int[] parent;
26    int[] rank;
27    DSU(int n)
28    {
29        parent = new int[n];
30        rank = new int[n];
31        for(int i=0;i<n;i++)
32        {
33            parent[i] = i;
34        }
35
36
37
38    }
39
40    int find(int x)
41    {
42        if(parent[x]!= x)
43            parent[x] = find(parent[x]);
44        
45        return parent[x];
46    }
47    
48    boolean union(int x, int y)
49    {
50        int px = find(x), py = find(y);
51        if(px == py)
52            return false;
53        
54        if(rank[px] > rank[py])
55            parent[py] = px;
56        else if(rank[py] > rank[px])
57            parent[px] = py;
58        else
59        {
60            parent[py] = px;
61            rank[px]++;
62        }
63        return true;
64    }
65
66    int numComps()
67    {
68        HashSet<Integer> hSet = new HashSet<Integer>();
69        for(int i=0;i<parent.length;i++)
70        {
71            if(!hSet.contains(find(i)))
72            {
73                hSet.add(parent[i]);
74            }
75        }
76
77        return hSet.size();
78    }
79
80
81}