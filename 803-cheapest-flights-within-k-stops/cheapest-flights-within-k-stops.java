class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
    {
             int[] dist = new int[n];
             Arrays.fill(dist, Integer.MAX_VALUE);
             dist[src]= 0;
             for(int j=1;j<=k+1;j++)
             {
                int[] temp = Arrays.copyOf(dist, n);
                for(int i=0;i<flights.length;i++)
                {
                    if(dist[flights[i][0]] != Integer.MAX_VALUE && dist[flights[i][0]] + flights[i][2] < temp[flights[i][1]])
                        temp[flights[i][1]] = dist[flights[i][0]] + flights[i][2];
                }
                dist = temp;
             }

            return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];


    }
}