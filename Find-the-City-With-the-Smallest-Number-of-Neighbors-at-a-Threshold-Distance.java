1class Solution {
2    public int findTheCity(int n, int[][] edges, int distanceThreshold) 
3    {
4        int[][] dist = new int[n][n];
5        for(int i=0;i<n;i++)
6            Arrays.fill(dist[i], Integer.MAX_VALUE/2-1);
7        for(int i=0;i<n;i++)
8            dist[i][i] = 0;
9        
10        for(int[] edge : edges)
11        {
12            dist[edge[0]][edge[1]] = edge[2];
13            dist[edge[1]][edge[0]] = edge[2];
14        }
15
16        for(int k=0;k<n;k++)
17        {
18            for(int i=0;i<n;i++)
19            {
20                for(int j=0;j<n;j++)
21                {
22                    if(dist[i][j] > dist[i][k] + dist[k][j])
23                        dist[i][j] = dist[i][k] + dist[k][j];
24                }
25
26            }
27
28        }
29        
30        int minCities = n, index = -1;
31        for(int i=0;i<n;i++)
32        {
33            int cities = 0;
34            for(int j=0;j<n;j++)
35            {
36                if(j != i && dist[i][j] <= distanceThreshold)
37                {
38                    cities++;
39
40                }
41
42            }
43            if(cities <= minCities)
44            {
45                minCities = cities;
46                index = i;
47            }
48        }
49        
50        
51    return index;
52    }
53}