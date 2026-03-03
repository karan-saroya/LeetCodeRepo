class Solution {
public:
    void bfs(int i, int j, vector<vector<bool>> & visited, vector<vector<char>>& grid)
    {
        deque<pair<int,int>> queue;
        int max_rows= grid.size();
        int max_columns = grid[0].size();
        queue.push_back(make_pair(i,j));
        while(queue.size())
        {
            pair<int,int> p = queue.front();
            queue.pop_front();
            
            //top
            if(p.first-1 >=0 && !visited[p.first-1][p.second] && grid[p.first-1][p.second] == '1')
            
            {
                visited[p.first-1][p.second] = true;
                queue.push_back(make_pair(p.first-1, p.second));
            }
            //left
            if(p.second-1 >=0 && !visited[p.first][p.second-1] && grid[p.first][p.second -1 ] == '1')
            {
                 visited[p.first][p.second-1] = true;
                queue.push_back(make_pair(p.first, p.second-1));
            }
            //right
            if(p.second+1 < max_columns && !visited[p.first][p.second+1] && grid[p.first][p.second+1] == '1')
            {
                visited[p.first][p.second+1] = true;
                queue.push_back(make_pair(p.first, p.second+1));
            }
            //down
            if(p.first+1 < max_rows && !visited[p.first+1][p.second] &&  grid[p.first+1][p.second] == '1')
            {
                visited[p.first+1][p.second] = true;
                queue.push_back(make_pair(p.first+1, p.second));
            }
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
                    bfs(i,j, visited, grid);
                }
            }
        }
        return num_comp;
    }
};