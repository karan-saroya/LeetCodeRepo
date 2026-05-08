1class Solution {
2    boolean[][] visited;
3    public void wallsAndGates(int[][] rooms) 
4    {
5        visited= new boolean[rooms.length][rooms[0].length];
6
7        List<List<Integer>> currList = new ArrayList<List<Integer>>();
8
9        for(int i=0;i<rooms.length;i++)
10        {
11            for(int j=0;j<rooms[0].length;j++)
12            {
13                if(rooms[i][j] ==  0)
14                {
15                    List<Integer> coord = new ArrayList<Integer>();
16                    coord.add(i);
17                    coord.add(j);
18                    currList.add(coord);
19                    visited[i][j] = true;
20                }
21
22            }
23        }
24
25    //System.out.println(currList);
26    while(!currList.isEmpty())
27    {
28        List<List<Integer>> child= new ArrayList<List<Integer>>(); 
29            while(!currList.isEmpty())
30            {
31                List<Integer> ord = currList.removeFirst();        
32                
33                
34                if(ord.get(0) +1 < rooms.length && !visited[ord.get(0) + 1][ord.get(1)])
35                {
36                    if(rooms[ord.get(0) +1][ord.get(1)] == 0)
37                    {
38                        List<Integer> coord = new ArrayList<Integer>();
39                        coord.add(ord.get(0) +1);
40                        coord.add(ord.get(1));
41                        child.add(coord);
42                        visited[ord.get(0) + 1][ord.get(1)]= true;
43                    }
44                    else if(rooms[ord.get(0) +1][ord.get(1)] == -1)
45                    {
46                        
47                    }
48                    else if(rooms[ord.get(0) +1][ord.get(1)] == Integer.MAX_VALUE)
49                    {
50
51                        rooms[ord.get(0) +1][ord.get(1)] = rooms[ord.get(0)][ord.get(1)] + 1;
52                        List<Integer> coord = new ArrayList<Integer>();
53                        coord.add(ord.get(0) +1);
54                        coord.add(ord.get(1));
55                        child.add(coord);
56                        visited[ord.get(0) + 1][ord.get(1)]= true;
57                    }
58
59                }
60
61                if(ord.get(0) -1 >= 0 && !visited[ord.get(0) -1][ord.get(1)])
62                {
63                    if(rooms[ord.get(0) -1][ord.get(1)] == 0)
64                    {
65                        List<Integer> coord = new ArrayList<Integer>();
66                        coord.add(ord.get(0) -1);
67                        coord.add(ord.get(1));
68                        child.add(coord);
69                        visited[ord.get(0) - 1][ord.get(1)]= true;
70                    }
71                    else if(rooms[ord.get(0) -1][ord.get(1)] == -1)
72                    {
73                    }
74                    else
75                    {
76
77                        rooms[ord.get(0) -1][ord.get(1)] = rooms[ord.get(0)][ord.get(1)] + 1;
78                        List<Integer> coord = new ArrayList<Integer>();
79                        coord.add(ord.get(0) -1);
80                        coord.add(ord.get(1));
81                        child.add(coord);
82                        visited[ord.get(0) - 1][ord.get(1)]= true;
83                    }
84
85                }
86
87
88                  if(ord.get(1) -1 >= 0 && !visited[ord.get(0) ][ord.get(1)-1])
89                {
90                    if(rooms[ord.get(0)][ord.get(1)-1] == 0)
91                    {
92                        List<Integer> coord = new ArrayList<Integer>();
93                        coord.add(ord.get(0) );
94                        coord.add(ord.get(1)-1);
95                        child.add(coord);
96
97                        visited[ord.get(0) ][ord.get(1)-1 ]= true;
98                    }
99                    else if(rooms[ord.get(0) ][ord.get(1)-1] == -1)
100                    {
101                        
102                    }
103                    else
104                    {
105
106                        rooms[ord.get(0) ][ord.get(1)-1] = rooms[ord.get(0)][ord.get(1)] + 1;
107                        List<Integer> coord = new ArrayList<Integer>();
108                        coord.add(ord.get(0) );
109                        coord.add(ord.get(1)-1);
110                        child.add(coord);
111                        visited[ord.get(0) ][ord.get(1)-1 ]= true;
112
113                    }
114
115                }
116
117                if(ord.get(1) +1 < rooms[0].length && !visited[ord.get(0) ][ord.get(1)+1])
118                {
119                    if(rooms[ord.get(0)][ord.get(1)+1] == 0)
120                    {
121                        List<Integer> coord = new ArrayList<Integer>();
122                        coord.add(ord.get(0) );
123                        coord.add(ord.get(1)+1);
124                        child.add(coord);
125                                                visited[ord.get(0) ][ord.get(1)+1 ]= true;
126
127                    }
128                    else if(rooms[ord.get(0) ][ord.get(1)+1] == -1)
129                    {
130                        
131                    }
132                    else
133                    {
134
135                        rooms[ord.get(0) ][ord.get(1)+1] = rooms[ord.get(0)][ord.get(1)] + 1;
136                        List<Integer> coord = new ArrayList<Integer>();
137                        coord.add(ord.get(0) );
138                        coord.add(ord.get(1)+1);
139                        child.add(coord);
140                                                visited[ord.get(0) ][ord.get(1)+1 ]= true;
141
142                    }
143
144                }
145            }
146
147            //System.out.println(child);
148           // System.out.println(currList);
149            
150            currList.addAll(child);
151           // System.out.println(currList);
152         /*    for(int i=0;i<rooms.length;i++)
153        {
154            for(int j=0;j<rooms[0].length;j++)
155            {
156                System.out.print(visited[i][j] + " ");
157 
158            }
159            System.out.println("");
160        }
161
162
163         for(int i=0;i<rooms.length;i++)
164        {
165            for(int j=0;j<rooms[0].length;j++)
166            {
167                System.out.print(rooms[i][j] + " ");
168 
169            }
170            System.out.println("");
171        }
172            
173            System.out.println(
174                "Reset"
175            );
176            */
177
178    }
179
180
181
182
183
184        
185    }
186}