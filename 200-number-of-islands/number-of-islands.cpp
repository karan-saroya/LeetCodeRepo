class Solution {
public:
    void dfs(int i, int j, vector<vector<bool>> & visited, vector<vector<char>>& grid)
    {
        int max_rows= grid.size();
        int max_columns = grid[0].size();
             //top
            if(i-1 >=0 && !visited[i-1][j] && grid[i-1][j] == '1')
            
            {
                visited[i-1][j] = true;
                dfs(i-1, j, visited, grid);
            }
            //left
            if(j-1 >=0 && !visited[i][j-1] && grid[i][j -1 ] == '1')
            {
                 visited[i][j-1] = true;
                dfs(i, j-1, visited, grid);
            }
            //right
            if(j+1 < max_columns && !visited[i][j+1] && grid[i][j+1] == '1')
            {
                visited[i][j+1] = true;
                dfs(i, j+1, visited, grid);
            }
            //down
            if(i+1 < max_rows && !visited[i+1][j] &&  grid[i+1][j] == '1')
            {
                visited[i+1][j] = true;
                dfs(i+1, j, visited, grid);
            }
        
    }
    int numIslands(vector<vector<char>>& grid) {
        vector<vector<bool>> visited;

        int num_comp=0;
        for(int i=0;i<grid.size();i++)
        {
            vector<bool> vec;
            visited.push_back(vec);
            for(int j=0;j<grid[0].size();j++)
                visited[i].push_back(false);
        }
        
        for(int i=0;i<grid.size();i++)
        {
            for(int j=0;j<grid[0].size();j++)
            {
                if(!visited[i][j] && grid[i][j] == '1')
                {
                    num_comp++;
                    dfs(i,j, visited, grid);
                }
            }
        }
        return num_comp;
    }
};