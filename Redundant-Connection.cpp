1class DSU
2{
3    public:
4    vector<int> parent;
5    vector<int> rank;
6    DSU(int n)
7    {
8        for(int i=0;i<=n;i++)
9        {
10            parent.push_back(i);
11            rank.push_back(1);
12        }
13    }
14    int find(int x)
15    {
16        if(parent[x]!= x)
17        {
18            parent[x] = find(parent[x]);
19        }
20        return parent[x];
21    }
22    bool _union(int x, int y)
23    {
24        int px = find(x), py= find(y);
25
26        if(px == py)
27            return false;
28        if(rank[px] > rank[py])
29        {
30            parent[py] = px;
31            
32        }
33        else if(rank[px] < rank[py])
34        {
35            parent[px] = py;
36            
37        }
38        else
39        {
40            parent[py] = px;
41            rank[px]++;
42           
43        }
44        return true;
45    }
46};
47class Solution {
48public:
49    vector<int> findRedundantConnection(vector<vector<int>>& edges) 
50    {
51        DSU dsu(edges.size());
52        vector<int> ans;
53        for(int i=0;i<edges.size();i++)
54        {
55            if(dsu._union(edges[i][0], edges[i][1]))
56            {
57                // do nothing
58            }
59            else
60            {
61                ans = {edges[i][0], edges[i][1]};
62            }
63        }
64        return ans;
65    }
66};
67