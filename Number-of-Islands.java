1class Solution {
2    boolean[][] visited;
3    int num_comps = 0;
4    public int numIslands(char[][] grid) 
5    {
6        visited = new  boolean[grid.length][grid[0].length];
7        for(int i=0;i<grid.length;i++)
8        {
9            for(int j=0;j<grid[0].length;j++)
10                visited[i][j] = false;
11        }
12
13        for(int i=0;i<grid.length;i++)
14        {
15            for(int j=0;j<grid[0].length;j++)
16            {
17                    if(!visited[i][j] && grid[i][j] == '1')
18                    {
19                        visited[i][j] = true;
20                        dfs(i,j, grid);
21                        this.num_comps++;
22                    }
23
24            }
25        }
26        return this.num_comps;
27        
28    }
29    void dfs(int i, int j, char[][] grid)
30    {
31         if(i+1 < grid.length && !visited[i+1][j] && grid[i+1][j] == '1')
32        {
33                        visited[i+1][j] = true;
34                        dfs(i+1,j, grid);
35                        
36        }
37        if(i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == '1')
38        {
39                        visited[i-1][j] = true;
40                        dfs(i-1,j, grid);
41                        
42        }
43
44         if(j+1 < grid[0].length && !visited[i][j+1] && grid[i][j+1] == '1')
45        {
46                        visited[i][j+1] = true;
47                        dfs(i,j+1, grid);
48                        
49        }
50        if(j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == '1')
51        {
52                        visited[i][j-1] = true;
53                        dfs(i,j-1, grid);
54                        
55        }
56
57    }
58
59}