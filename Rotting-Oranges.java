1class Solution {
2    boolean[][] visited;
3    int [][] dist;
4    int max = 0;
5    public int orangesRotting(int[][] grid) 
6    {
7        visited = new boolean[grid.length][grid[0].length];
8        dist = new int[grid.length][grid[0].length];
9        List<List<Integer>> currList = new ArrayList<List<Integer>>();
10        for(int i=0;i<grid.length;i++)
11        {
12            for(int j=0;j<grid[0].length;j++)
13            {
14                dist[i][j]= Integer.MAX_VALUE;
15
16            }
17        }
18        for(int i=0;i<grid.length;i++)
19        {
20            for(int j=0;j<grid[0].length;j++)
21            {
22                if(grid[i][j] == 2)
23                {
24                    List<Integer> coord = new ArrayList<Integer>();
25                    coord.add(i);
26                    coord.add(j);
27                    currList.add(coord);
28                    visited[i][j] = true;
29                    dist[i][j] =0;
30                }
31
32            }
33        }
34                //System.out.println(currList);
35
36        while(!currList.isEmpty())
37        {
38            List<List<Integer>> child = new ArrayList<List<Integer>>();
39            while(!currList.isEmpty())
40            {
41                List<Integer> ord = currList.removeFirst();
42                if(ord.get(0) +1 < grid.length && !visited[ord.get(0) +1][ord.get(1)])
43                {
44                    if(grid[ord.get(0) + 1][ ord.get(1)] == 0 )
45                    {
46                        
47                    }
48                    else if(grid[ord.get(0) + 1][ ord.get(1)] == 1)
49                    {
50                            visited[ord.get(0) + 1][ord.get(1)] = true;
51                            List<Integer> coord = new ArrayList<Integer>();
52                            coord.add(ord.get(0) + 1);
53                            coord.add(ord.get(1));
54                            child.add(coord);
55                            dist[ord.get(0) + 1][ord.get(1)] = dist[ord.get(0)][ord.get(1)] + 1;
56                            
57                            
58                    }
59                    else if(grid[ord.get(0) + 1][ ord.get(1)] == 2)
60                    {
61                            visited[ord.get(0) + 1][ord.get(1)] = true;
62                            List<Integer> coord = new ArrayList<Integer>();
63                            coord.add(ord.get(0) + 1);
64                            coord.add(ord.get(1));
65                            child.add(coord);
66                            
67
68                    }
69                }
70
71                if(ord.get(0) -1 >= 0&& !visited[ord.get(0) -1][ord.get(1)])
72                {
73                    if(grid[ord.get(0) -1][ ord.get(1)] == 0 )
74                    {
75                        
76                    }
77                    else if(grid[ord.get(0) -1][ ord.get(1)] == 1)
78                    {
79                         visited[ord.get(0) -1][ord.get(1)] = true;
80                            List<Integer> coord = new ArrayList<Integer>();
81                            coord.add(ord.get(0) -1);
82                            coord.add(ord.get(1));
83                            child.add(coord);
84                            dist[ord.get(0) -1][ord.get(1) ] = dist[ord.get(0)][ord.get(1)] + 1;
85                            
86                            
87                    }
88                    else if(grid[ord.get(0) -1][ ord.get(1)] == 2)
89                    {
90                        visited[ord.get(0) -1][ord.get(1)] = true;
91                            List<Integer> coord = new ArrayList<Integer>();
92                            coord.add(ord.get(0) -1);
93                            coord.add(ord.get(1));
94                            child.add(coord);
95                            
96                        
97                    }
98                }
99
100                if(ord.get(1) -1 >= 0&& !visited[ord.get(0)][ord.get(1) -1])
101                {
102                    if(grid[ord.get(0)][ ord.get(1) -1] == 0 )
103                    {
104                        
105                    }
106                    else if(grid[ord.get(0)][ ord.get(1) -1] == 1)
107                    {
108                            visited[ord.get(0)][ord.get(1) -1] = true;
109                            List<Integer> coord = new ArrayList<Integer>();
110                            coord.add(ord.get(0));
111                            coord.add(ord.get(1) -1);
112                            child.add(coord);
113                            dist[ord.get(0) ][ord.get(1) -1] = dist[ord.get(0)][ord.get(1)] + 1;
114
115                            
116                    }
117                    else if(grid[ord.get(0)][ ord.get(1) -1] == 2)
118                    {   
119                            visited[ord.get(0)][ord.get(1) -1] = true;
120                            List<Integer> coord = new ArrayList<Integer>();
121                            coord.add(ord.get(0));
122                            coord.add(ord.get(1) -1);
123                            child.add(coord);
124                            
125                    }
126                }
127
128
129                  if(ord.get(1) +1 < grid[0].length && !visited[ord.get(0)][ord.get(1) +1])
130                {
131                    if(grid[ord.get(0)][ ord.get(1) +1] == 0 )
132                    {
133                        
134                    }
135                    else if(grid[ord.get(0)][ ord.get(1) +1] == 1)
136                    {
137                            visited[ord.get(0)][ord.get(1) +1] = true;
138                            List<Integer> coord = new ArrayList<Integer>();
139                            coord.add(ord.get(0));
140                            coord.add(ord.get(1) +1);
141                            child.add(coord);
142                            dist[ord.get(0) ][ord.get(1) +1] = dist[ord.get(0)][ord.get(1)] + 1;
143
144                          
145                    }
146                    else if(grid[ord.get(0)][ ord.get(1) +1] == 2)
147                    {
148                            visited[ord.get(0)][ord.get(1) +1] = true;
149                            List<Integer> coord = new ArrayList<Integer>();
150                            coord.add(ord.get(0));
151                            coord.add(ord.get(1) +1);
152                            child.add(coord);
153                           
154                    }
155                }
156            }
157//System.out.println(currList);
158
159            currList.addAll(child);
160
161                    //System.out.println(currList);
162                   // System.out.println("Reset");
163
164        }
165    boolean freshAvail = false;
166     for(int i=0;i<grid.length;i++)
167        {
168            for(int j=0;j<grid[0].length;j++)
169            {
170                if(grid[i][j] == 1 && dist[i][j] == Integer.MAX_VALUE)
171                {
172                    freshAvail = true;
173                    max = -1;
174                    break;
175                }
176                else if(grid[i][j] == 1)
177                {
178                    if(dist[i][j] > max)
179                        max = dist[i][j];
180
181                }
182
183            }
184            if(freshAvail)
185                break;
186        }
187
188    return max;
189        
190    }
191}