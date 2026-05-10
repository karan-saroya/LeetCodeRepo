class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) 
    {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE/2-1);
        for(int i=0;i<n;i++)
            dist[i][i] = 0;
        
        for(int[] edge : edges)
        {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }

            }

        }
        
        int minCities = n, index = -1;
        for(int i=0;i<n;i++)
        {
            int cities = 0;
            for(int j=0;j<n;j++)
            {
                if(j != i && dist[i][j] <= distanceThreshold)
                {
                    cities++;

                }

            }
            if(cities <= minCities)
            {
                minCities = cities;
                index = i;
            }
        }
        
        
    return index;
    }
}