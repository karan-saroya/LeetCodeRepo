1class Solution {
2    public int minimumEffortPath(int[][] heights) 
3    {
4        Djikstra dj = new Djikstra(heights.length, heights[0].length);
5        int [][] sol = dj.shortestPath(heights);
6        return sol[heights.length-1][heights[0].length-1];
7
8        
9    }
10}
11class Djikstra
12{
13    int[][] dist;
14    Djikstra(int r, int c)
15    {
16        dist = new int[r][c];
17        for(int i=0;i<r;i++)
18        {
19            for(int j=0;j<c;j++)
20                dist[i][j]= Integer.MAX_VALUE;
21        }
22        dist[0][0] = 0;
23    }
24
25    int[][] shortestPath(int[][] heights)
26    {
27        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[2], b[2]));
28        pq.offer(new int[]{0,0,0});
29        while(!pq.isEmpty())
30        {
31            int[] cand = pq.poll();
32            int x =cand[0], y = cand[1], d = cand[2];
33            if(d > dist[x][y])
34                continue;
35            if(x - 1 >=0)
36            {
37                if(dist[x-1][y] > Math.max(Math.abs(heights[x][y]-heights[x-1][y]), dist[x][y]))
38                    {
39                        dist[x-1][y] = Math.max(Math.abs(heights[x][y]-heights[x-1][y]), dist[x][y]);
40                        pq.offer(new int[]{x-1, y, Math.max(Math.abs(heights[x][y]-heights[x-1][y]), dist[x][y])});
41                    }
42            }
43            if(x+1 < heights.length)
44            {
45                     if(dist[x+1][y] > Math.max(Math.abs(heights[x][y]-heights[x+1][y]), dist[x][y]))
46                    {
47                        dist[x+1][y] = Math.max(Math.abs(heights[x][y]-heights[x+1][y]), dist[x][y]);
48                        pq.offer(new int[]{x+1, y, Math.max(Math.abs(heights[x][y]-heights[x+1][y]), dist[x][y])});
49                    }
50            }
51            if(y-1 >=0 )
52            {
53                if(dist[x][y-1] > Math.max(Math.abs(heights[x][y]-heights[x][y-1]), dist[x][y]))
54                    {
55                        dist[x][y-1] = Math.max(Math.abs(heights[x][y]-heights[x][y-1]), dist[x][y]);
56                        pq.offer(new int[]{x, y-1, Math.max(Math.abs(heights[x][y]-heights[x][y-1]), dist[x][y])});
57                    }
58            }
59            if(y+1 < heights[0].length)
60            {
61                    if(dist[x][y+1] > Math.max(Math.abs(heights[x][y]-heights[x][y+1]), dist[x][y]))
62                    {
63                        dist[x][y+1] = Math.max(Math.abs(heights[x][y]-heights[x][y+1]), dist[x][y]);
64                        pq.offer(new int[]{x, y+1, Math.max(Math.abs(heights[x][y]-heights[x][y+1]), dist[x][y])});
65                    }
66            }
67        }
68
69        return dist;
70
71
72    }
73}