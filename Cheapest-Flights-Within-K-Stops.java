1class Solution {
2    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
3    {
4             int[] dist = new int[n];
5             Arrays.fill(dist, Integer.MAX_VALUE);
6             dist[src]= 0;
7             for(int j=1;j<=k+1;j++)
8             {
9                int[] temp = Arrays.copyOf(dist, n);
10                for(int i=0;i<flights.length;i++)
11                {
12                    if(dist[flights[i][0]] != Integer.MAX_VALUE && dist[flights[i][0]] + flights[i][2] < temp[flights[i][1]])
13                        temp[flights[i][1]] = dist[flights[i][0]] + flights[i][2];
14                }
15                dist = temp;
16             }
17
18            return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
19
20
21    }
22}