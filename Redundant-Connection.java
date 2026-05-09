1class Solution {
2    public int[] findRedundantConnection(int[][] edges) 
3    {
4        DSU dsu = new DSU(edges.length);
5        int[] ans= new int[2];
6        for(int i=0;i<edges.length;i++)
7        {
8            if(!dsu.union(edges[i][0]-1, edges[i][1]-1))
9            {
10                ans[0] = edges[i][0];
11                ans[1] = edges[i][1];
12                break;
13            }
14            
15        }
16        return ans;
17    }
18    
19}
20
21class DSU
22{
23    int[] parent;
24    int[] rank;
25    DSU(int n)
26    {
27        parent = new int [n];
28        rank = new int[n];
29        for(int i=0;i<n;i++)
30            parent[i] = i;
31
32
33    }
34    int find(int x)
35    {
36        if(parent[x] != x)
37            parent[x] = find(parent[x]);
38
39        return parent[x];
40    }
41
42    boolean  union(int x, int y)
43    {   
44        int px = find(x), py = find(y);
45        if(px == py)
46            return false;
47        if(rank[px] > rank[py])
48            parent[py] = px;
49        else if(rank[py] > rank[px])
50            parent[px] = py;
51        else
52        {
53            parent[py] = px;
54            rank[px]++;
55        }
56        return true;
57    }
58
59
60
61}
62