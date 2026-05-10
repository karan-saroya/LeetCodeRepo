class Solution {
    public int networkDelayTime(int[][] times, int n, int k) 
    {
         List<List<int[]>> adjList = new ArrayList<List<int[]>>();
         Djikstra dj = new Djikstra(n);
         for(int i=0;i<=n;i++)
         {
            adjList.add(new ArrayList<int[]>());
         }
         for(int i=0;i<times.length;i++)
         {
            adjList.get(times[i][0]).add(new int[]{times[i][2], times[i][1]});
         }

         dj.shortestPath(k, adjList);
         int ans = dj.maxShortestPath();
        if(ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;

    }
}
class Djikstra
{
    int[] dist;
    Djikstra(int n)
    {
        dist = new int[n+1];
        for(int i=1;i<dist.length;i++)
            dist[i] = Integer.MAX_VALUE;
    }

    boolean shortestPath(int src, List<List<int[]>> adj)
    {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0, src});
        dist[src] =0;

        while(!pq.isEmpty())
        {
            int[] candidate = pq.poll();
            int weight= candidate[0];
            int node = candidate[1];
            if(weight > dist[node])
                continue;
            
            for(int[] edge : adj.get(node))
            {
                int edge_weight =edge[0];
                int edge_node = edge[1];

                if(dist[node] + edge_weight < dist[edge_node])
                    {
                        dist[edge_node] = dist[node] + edge_weight;
                        pq.offer(new int[]{dist[edge_node], edge_node});
                    }


            }

 
        }
        // for(int i=1;i<dist.length;i++)
        //     System.out.print(dist[i] + ",");
        return true;

    }

    
    int maxShortestPath()
    {
        int max = -1;
        for(int i=1;i<dist.length;i++)
        {
            if(max < dist[i])
                max = dist[i];
        }
        return max;
    }


}