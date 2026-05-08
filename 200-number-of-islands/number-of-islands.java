class Solution {
    boolean[][] visited;
    int num_comps = 0;
    public int numIslands(char[][] grid) 
    {
        visited = new  boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
                visited[i][j] = false;
        }

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                    if(!visited[i][j] && grid[i][j] == '1')
                    {
                        visited[i][j] = true;
                        dfs(i,j, grid);
                        this.num_comps++;
                    }

            }
        }
        return this.num_comps;
        
    }
    void dfs(int i, int j, char[][] grid)
    {
         if(i+1 < grid.length && !visited[i+1][j] && grid[i+1][j] == '1')
        {
                        visited[i+1][j] = true;
                        dfs(i+1,j, grid);
                        
        }
        if(i-1 >= 0 && !visited[i-1][j] && grid[i-1][j] == '1')
        {
                        visited[i-1][j] = true;
                        dfs(i-1,j, grid);
                        
        }

         if(j+1 < grid[0].length && !visited[i][j+1] && grid[i][j+1] == '1')
        {
                        visited[i][j+1] = true;
                        dfs(i,j+1, grid);
                        
        }
        if(j-1 >= 0 && !visited[i][j-1] && grid[i][j-1] == '1')
        {
                        visited[i][j-1] = true;
                        dfs(i,j-1, grid);
                        
        }

    }

}