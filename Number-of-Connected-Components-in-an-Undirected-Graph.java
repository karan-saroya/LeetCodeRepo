1class Solution {
2    public int countComponents(int n, int[][] edges) 
3    {
4        DSU dsu = new DSU(n);
5        System.out.println("here");
6        for(int i=0;i<edges.length;i++)
7        {
8            dsu.union(edges[i][0], edges[i][1]);
9        }
10        //System.out.println("Noiw here ");
11        return dsu.findComponents();
12        
13    }
14}
15class DSU
16{
17    int[] parent;
18    int[] rank;
19
20    DSU(int n)
21    {
22        parent = new int[n];
23        rank = new int[n];
24        for(int i=0;i<n;i++)
25        {
26            parent[i]= i;
27            rank[i]= 0;
28        }
29
30    }
31    int find(int x)
32    {
33        if(parent[x] != x)
34            parent[x] = find(parent[x]);
35
36        return parent[x];
37    }
38
39    boolean union(int x, int y)
40    {
41        //System.out.println("Find called for "+ x + " "+ y);
42        int px = find(x), py = find(y);
43        //System.out.println("Find finished");
44        if(px == py)
45            return false;
46        if(rank[px] > rank[py])
47        {
48            parent[py] = px;
49        }
50        else if(rank[py] > rank[px])
51        {
52            parent[px] = py;
53
54        }
55        else
56        {
57            parent[py] = px;
58            rank[px]++;
59        }
60        return true;
61    }
62    int findComponents()
63    {
64        HashSet<Integer> hSet = new HashSet<Integer>();
65        for(int i=0;i<parent.length;i++)
66        {
67            if(!hSet.contains(find(i)))
68            {
69                hSet.add(parent[i]);
70            }
71        }
72        // System.out.println("Parents");
73        // for(int i=0;i<parent.length;i++)
74        // {
75        //     System.out.println(parent[i]);
76        // }
77
78        // System.out.println("Parents end");
79         return hSet.size();
80    }
81
82
83}