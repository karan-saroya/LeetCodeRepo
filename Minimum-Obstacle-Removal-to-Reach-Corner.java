1class Solution {
2    public int minimumObstacles(int[][] grid) 
3    {
4        boolean[][] visited = new boolean[grid.length][grid[0].length];
5        int[][] dist = new int[grid.length][grid[0].length];
6        for(int i=0;i<grid.length;i++)
7        {
8            Arrays.fill(dist[i], Integer.MAX_VALUE);
9            Arrays.fill(visited[i], false);
10
11        }
12
13        dist[0][0] = 0;
14        visited[0][0] = true;
15        Deque<List<Integer>> currList = new ArrayDeque<List<Integer>>();
16        List<Integer> startList = new ArrayList<Integer>();
17        startList.add(0);
18        startList.add(0);
19        
20        currList.add(startList);
21        
22       
23            while(!currList.isEmpty())
24            {
25                List<Integer> node = currList.removeFirst();
26                int currX = node.get(0), currY = node.get(1);
27                if(currX == grid.length -1 && currY == grid[0].length -1)
28                    break;
29                if(currX - 1 >=0 && !visited[currX-1][currY])
30                {
31                    visited[currX-1][currY]  = true;
32                    if( grid[currX - 1 ][ currY ] == 1 )
33                    {
34                        dist[currX -1][currY] = dist[currX][currY]+1;
35                        List<Integer> list = new ArrayList<Integer>();
36                        list.add(currX-1);
37                        
38                        list.add(currY);
39                        currList.offerLast(list);
40                    }
41                    else
42                    {
43                        dist[currX -1][currY] = dist[currX][currY];
44
45                        List<Integer> list = new ArrayList<Integer>();
46                        list.add(currX-1);
47                        list.add(currY);
48                        currList.offerFirst(list);
49                    }
50
51                }
52                if(currX +1 < grid.length && !visited[currX+1][currY])
53                {
54                    visited[currX+1 ][currY]  = true;
55                    if( grid[currX + 1 ][ currY ] == 1 )
56                    {
57                        dist[currX +1][currY] = dist[currX][currY] +1;
58
59                        List<Integer> list = new ArrayList<Integer>();
60                        list.add(currX+1);
61                        list.add(currY);
62                        currList.offerLast(list);
63                    }
64                    else
65                    {
66                        dist[currX +1][currY] = dist[currX][currY];
67
68                        List<Integer> list = new ArrayList<Integer>();
69                        list.add(currX+1);
70                        list.add(currY);
71                        currList.offerFirst(list);
72                    }
73
74                }
75                if(currY - 1 >= 0 && !visited[currX][currY -1])
76                {
77                    visited[currX ][currY -1 ]  = true;
78                    if( grid[currX  ][ currY -1 ] == 1 )
79                    {
80                        dist[currX][currY-1] = dist[currX][currY] + 1;
81
82                        List<Integer> list = new ArrayList<Integer>();
83                        list.add(currX);
84                        list.add(currY - 1);
85                        currList.offerLast(list);
86                    }
87                    else
88                    {
89                        dist[currX ][currY-1] = dist[currX][currY];
90
91                        List<Integer> list = new ArrayList<Integer>();
92                        list.add(currX);
93                        list.add(currY - 1);
94                        currList.offerFirst(list);
95                    }
96
97                }
98                if(currY + 1 < grid[0].length && !visited[currX][currY +1])
99                {
100                    visited[currX ][currY + 1 ]  = true;
101                    if( grid[currX  ][ currY +1 ] == 1 )
102                    {
103                        dist[currX][currY+1] = dist[currX][currY] + 1;
104
105                        List<Integer> list = new ArrayList<Integer>();
106                        list.add(currX);
107                        list.add(currY +1);
108                        currList.offerLast(list);
109                    }
110                    else
111                    {
112
113                        dist[currX][currY+1] = dist[currX][currY];
114
115                        List<Integer> list = new ArrayList<Integer>();
116                        list.add(currX);
117                        list.add(currY +1);
118                        currList.offerFirst(list);
119                    }
120
121                }
122            }
123       
124        if(dist[grid.length-1][grid[0].length-1] == Integer.MAX_VALUE)
125            return -1;
126        else
127            return dist[grid.length-1][grid[0].length-1];
128        
129    }
130}