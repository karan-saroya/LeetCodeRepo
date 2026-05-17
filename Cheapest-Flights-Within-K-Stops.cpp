1class Solution {
2public:
3    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) 
4    {
5        vector<int> dist;
6        vector<vector<pair<int,int>>> adjList;
7        for(int i=0;i<n;i++)
8            dist.push_back(INT_MAX);
9        for(int i=0;i<n;i++)
10        {
11            vector<pair<int,int>> vec;
12            adjList.push_back(vec);
13        }
14        dist[src] = 0;
15        for(int i=0;i<flights.size();i++)
16        {
17            adjList[flights[i][0]].push_back({flights[i][1], flights[i][2]});
18        }  
19        for(int i=1;i<=k+1;i++)
20        {
21            vector<int> temp= dist;
22            for(int j=0;j<flights.size();j++)
23            {
24                int source = flights[j][0];
25                int dest = flights[j][1];
26                int weight = flights[j][2];
27                if(dist[source]!= INT_MAX && dist[source] + weight < temp[dest])
28                {
29                    temp[dest] = dist[source] + weight;
30                }            
31            }
32            dist= temp;
33        }
34        if(dist[dst] == INT_MAX)
35            return -1;
36        return dist[dst];
37    }
38};