1class Solution {
2public:
3    void bfs(int i, int j, vector<vector<bool>> & visited, vector<vector<char>>& grid)
4    {
5        deque<pair<int,int>> queue;
6        int max_rows= grid.size();
7        int max_columns = grid[0].size();
8        queue.push_back(make_pair(i,j));
9        while(queue.size())
10        {
11            pair<int,int> p = queue.front();
12            queue.pop_front();
13            
14            //top
15            if(p.first-1 >=0 && !visited[p.first-1][p.second] && grid[p.first-1][p.second] == '1')
16            
17            {
18                visited[p.first-1][p.second] = true;
19                queue.push_back(make_pair(p.first-1, p.second));
20            }
21            //left
22            if(p.second-1 >=0 && !visited[p.first][p.second-1] && grid[p.first][p.second -1 ] == '1')
23            {
24                 visited[p.first][p.second-1] = true;
25                queue.push_back(make_pair(p.first, p.second-1));
26            }
27            //right
28            if(p.second+1 < max_columns && !visited[p.first][p.second+1] && grid[p.first][p.second+1] == '1')
29            {
30                visited[p.first][p.second+1] = true;
31                queue.push_back(make_pair(p.first, p.second+1));
32            }
33            //down
34            if(p.first+1 < max_rows && !visited[p.first+1][p.second] &&  grid[p.first+1][p.second] == '1')
35            {
36                visited[p.first+1][p.second] = true;
37                queue.push_back(make_pair(p.first+1, p.second));
38            }
39        }
40    }
41    int numIslands(vector<vector<char>>& grid) {
42        vector<vector<bool>> visited;
43
44        int num_comp=0;
45        for(int i=0;i<grid.size();i++)
46        {
47            vector<bool> vec;
48            visited.push_back(vec);
49            for(int j=0;j<grid[0].size();j++)
50                visited[i].push_back(false);
51        }
52        
53        for(int i=0;i<grid.size();i++)
54        {
55            for(int j=0;j<grid[0].size();j++)
56            {
57                if(!visited[i][j] && grid[i][j] == '1')
58                {
59                    num_comp++;
60                    bfs(i,j, visited, grid);
61                }
62            }
63        }
64        return num_comp;
65    }
66};