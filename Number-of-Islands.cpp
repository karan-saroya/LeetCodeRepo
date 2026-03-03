1class Solution {
2public:
3    void dfs(int i, int j, vector<vector<bool>> & visited, vector<vector<char>>& grid)
4    {
5        int max_rows= grid.size();
6        int max_columns = grid[0].size();
7             //top
8            if(i-1 >=0 && !visited[i-1][j] && grid[i-1][j] == '1')
9            
10            {
11                visited[i-1][j] = true;
12                dfs(i-1, j, visited, grid);
13            }
14            //left
15            if(j-1 >=0 && !visited[i][j-1] && grid[i][j -1 ] == '1')
16            {
17                 visited[i][j-1] = true;
18                dfs(i, j-1, visited, grid);
19            }
20            //right
21            if(j+1 < max_columns && !visited[i][j+1] && grid[i][j+1] == '1')
22            {
23                visited[i][j+1] = true;
24                dfs(i, j+1, visited, grid);
25            }
26            //down
27            if(i+1 < max_rows && !visited[i+1][j] &&  grid[i+1][j] == '1')
28            {
29                visited[i+1][j] = true;
30                dfs(i+1, j, visited, grid);
31            }
32        
33    }
34    int numIslands(vector<vector<char>>& grid) {
35        vector<vector<bool>> visited;
36
37        int num_comp=0;
38        for(int i=0;i<grid.size();i++)
39        {
40            vector<bool> vec;
41            visited.push_back(vec);
42            for(int j=0;j<grid[0].size();j++)
43                visited[i].push_back(false);
44        }
45        
46        for(int i=0;i<grid.size();i++)
47        {
48            for(int j=0;j<grid[0].size();j++)
49            {
50                if(!visited[i][j] && grid[i][j] == '1')
51                {
52                    num_comp++;
53                    dfs(i,j, visited, grid);
54                }
55            }
56        }
57        return num_comp;
58    }
59};