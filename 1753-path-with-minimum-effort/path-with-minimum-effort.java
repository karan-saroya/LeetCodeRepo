class Solution {
    public int minimumEffortPath(int[][] heights) 
    {
        Djikstra dj = new Djikstra(heights.length, heights[0].length);
        int [][] sol = dj.shortestPath(heights);
        return sol[heights.length-1][heights[0].length-1];

        
    }
}
class Djikstra
{
    int[][] dist;
    Djikstra(int r, int c)
    {
        dist = new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
                dist[i][j]= Integer.MAX_VALUE;
        }
        dist[0][0] = 0;
    }

    int[][] shortestPath(int[][] heights)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty())
        {
            int[] cand = pq.poll();
            int x =cand[0], y = cand[1], d = cand[2];
            if(d > dist[x][y])
                continue;
            if(x - 1 >=0)
            {
                if(dist[x-1][y] > Math.max(Math.abs(heights[x][y]-heights[x-1][y]), dist[x][y]))
                    {
                        dist[x-1][y] = Math.max(Math.abs(heights[x][y]-heights[x-1][y]), dist[x][y]);
                        pq.offer(new int[]{x-1, y, Math.max(Math.abs(heights[x][y]-heights[x-1][y]), dist[x][y])});
                    }
            }
            if(x+1 < heights.length)
            {
                     if(dist[x+1][y] > Math.max(Math.abs(heights[x][y]-heights[x+1][y]), dist[x][y]))
                    {
                        dist[x+1][y] = Math.max(Math.abs(heights[x][y]-heights[x+1][y]), dist[x][y]);
                        pq.offer(new int[]{x+1, y, Math.max(Math.abs(heights[x][y]-heights[x+1][y]), dist[x][y])});
                    }
            }
            if(y-1 >=0 )
            {
                if(dist[x][y-1] > Math.max(Math.abs(heights[x][y]-heights[x][y-1]), dist[x][y]))
                    {
                        dist[x][y-1] = Math.max(Math.abs(heights[x][y]-heights[x][y-1]), dist[x][y]);
                        pq.offer(new int[]{x, y-1, Math.max(Math.abs(heights[x][y]-heights[x][y-1]), dist[x][y])});
                    }
            }
            if(y+1 < heights[0].length)
            {
                    if(dist[x][y+1] > Math.max(Math.abs(heights[x][y]-heights[x][y+1]), dist[x][y]))
                    {
                        dist[x][y+1] = Math.max(Math.abs(heights[x][y]-heights[x][y+1]), dist[x][y]);
                        pq.offer(new int[]{x, y+1, Math.max(Math.abs(heights[x][y]-heights[x][y+1]), dist[x][y])});
                    }
            }
        }

        return dist;


    }
}