1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) 
3    {
4         List<List<int[]>> adjList = new ArrayList<List<int[]>>();
5         Djikstra dj = new Djikstra(n);
6         for(int i=0;i<=n;i++)
7         {
8            adjList.add(new ArrayList<int[]>());
9         }
10         for(int i=0;i<times.length;i++)
11         {
12            adjList.get(times[i][0]).add(new int[]{times[i][2], times[i][1]});
13         }
14
15         dj.shortestPath(k, adjList);
16         int ans = dj.maxShortestPath();
17        if(ans == Integer.MAX_VALUE)
18            return -1;
19        else
20            return ans;
21
22    }
23}
24class Djikstra
25{
26    int[] dist;
27    Djikstra(int n)
28    {
29        dist = new int[n+1];
30        for(int i=1;i<dist.length;i++)
31            dist[i] = Integer.MAX_VALUE;
32    }
33
34    boolean shortestPath(int src, List<List<int[]>> adj)
35    {
36        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0],b[0]));
37        pq.offer(new int[]{0, src});
38        dist[src] =0;
39
40        while(!pq.isEmpty())
41        {
42            int[] candidate = pq.poll();
43            int weight= candidate[0];
44            int node = candidate[1];
45            if(weight > dist[node])
46                continue;
47            
48            for(int[] edge : adj.get(node))
49            {
50                int edge_weight =edge[0];
51                int edge_node = edge[1];
52
53                if(dist[node] + edge_weight < dist[edge_node])
54                    {
55                        dist[edge_node] = dist[node] + edge_weight;
56                        pq.offer(new int[]{dist[edge_node], edge_node});
57                    }
58
59
60            }
61
62 
63        }
64        // for(int i=1;i<dist.length;i++)
65        //     System.out.print(dist[i] + ",");
66        return true;
67
68    }
69
70    
71    int maxShortestPath()
72    {
73        int max = -1;
74        for(int i=1;i<dist.length;i++)
75        {
76            if(max < dist[i])
77                max = dist[i];
78        }
79        return max;
80    }
81
82
83}