1class Solution {
2public:
3    int numIslands(vector<vector<char>>& grid) 
4    {
5        vector<vector<bool>> visited;
6        int num_comps=0;
7        for(int i=0;i<grid.size();i++)
8        {
9            vector<bool> row;
10            visited.push_back(row);
11            for(int j=0;j<grid[0].size();j++)
12                    visited[i].push_back(false);
13        }
14
15        for(int i=0;i<grid.size();i++)
16        {
17            for(int j=0;j<grid[0].size();j++)
18                {
19                    if(!visited[i][j] && grid[i][j] == '1')
20                    {
21                       
22                        bfs(i,j, visited,grid);
23                        num_comps++;
24                    }
25                    
26                }
27        }
28        return num_comps;
29
30
31    }
32    void bfs(int startRow, int startCol, vector<vector<bool>>& visited, vector<vector<char>>& grid)
33    {
34        visited[startRow][startCol] = true;
35        queue<vector<int>> currList;
36        vector<int> startCoord{startRow, startCol};
37        currList.push(startCoord);
38        cout<<"here"<<endl;
39        while(!currList.empty())
40        {
41            queue<vector<int>> children;
42                
43            while(!currList.empty())
44            {
45                vector<int> currCoord = currList.front();
46                currList.pop();
47                int currRow = currCoord[0], currCol = currCoord[1];
48                if(currRow-1>=0 && grid[currRow -1][currCol] == '1' && !visited[currRow - 1][currCol]) 
49                {
50                    visited[currRow - 1][currCol] = true;
51                    vector<int> currChildCoord{currRow-1, currCol};
52                    children.push(currChildCoord);
53                }
54                 if(currRow+1 < grid.size() && grid[currRow +1][currCol] == '1' && !visited[currRow + 1][currCol]) 
55                {
56                    visited[currRow + 1][currCol] = true;
57                    vector<int> currChildCoord{currRow+1, currCol};
58                    children.push(currChildCoord);
59                }
60
61                 if(currCol-1>=0 && grid[currRow ][currCol-1] == '1' && !visited[currRow][currCol-1]) 
62                {
63                    visited[currRow ][currCol - 1] = true;
64                    vector<int> currChildCoord{currRow, currCol- 1};
65                    children.push(currChildCoord);
66                }
67
68                 if(currCol+1 < grid[0].size() && grid[currRow ][currCol+1] == '1' && !visited[currRow ][currCol+1]) 
69                {
70                    visited[currRow ][currCol+1] = true;
71                    vector<int> currChildCoord{currRow, currCol+1};
72                    children.push(currChildCoord);
73                }
74            }
75
76            while(!children.empty())
77            {
78                currList.push(children.front());
79                children.pop();
80            }
81
82        }
83
84    }
85};