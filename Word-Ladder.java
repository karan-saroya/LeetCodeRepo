1class Solution {
2    boolean[] visited;
3    boolean[][] adj_matrix;
4    int[] dist;
5    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
6    {
7        boolean endFound = false;
8                int index = -1;
9
10        for(int i=0;i<wordList.size();i++)
11        {
12            if(wordList.get(i).equals(endWord))
13            {
14                endFound= true;
15                index = i;
16                break;
17            }
18        }
19        if(!endFound)
20            return 0;
21        wordList.add(beginWord);
22        
23        visited = new boolean[wordList.size()];
24        dist = new int[wordList.size()];
25        adj_matrix= new boolean[wordList.size()][wordList.size()];
26        List<Integer> currList = new ArrayList<Integer>();
27    
28        for(int i=0;i<wordList.size();i++)
29        {
30            dist[i] = Integer.MAX_VALUE;
31
32            if(wordList.get(i).equals(beginWord))
33            {
34                currList.add(i);
35                visited[i] = true;
36                dist[i] = 0;                
37            }
38            
39            for(int j=i+1;j<wordList.size();j++)
40            {
41                if(compareString(wordList.get(i), wordList.get(j)))
42                {
43                    adj_matrix[i][j] = adj_matrix[j][i] = true;
44                }
45
46            }
47
48        }
49
50
51// for(int i=0;i<wordList.size();i++)
52//         {
53//             System.out.println(wordList.get(i));
54//             for(int j=0;j<wordList.size();j++)
55//             {
56//                 System.out.print(adj_matrix[i][j]+" ,");
57
58//             }
59
60//             System.out.println("");
61
62//         }
63
64
65
66
67        boolean found= false;
68        while(!currList.isEmpty())
69        {
70            List<Integer> child = new ArrayList<Integer>();
71            while(!currList.isEmpty())
72            {
73                int  x = currList.removeFirst();
74                
75                for(int i=0;i<adj_matrix[0].length;i++)
76                {
77                    if(!visited[i] && adj_matrix[x][i])
78                    {
79                        child.add(i);
80                        dist[i] = dist[x] + 1;
81                            if(i == index )
82                            {
83                                found = true;
84                                break;
85                            }
86                        visited[i] = true;
87                    }
88                }
89                if(found)
90                    break;
91            }
92            if(found)
93                break;
94            currList.addAll(child);
95        }
96        if(dist[index] == Integer.MAX_VALUE)
97            return 0;
98        return dist[index]+ 1 ;
99
100
101    }
102
103    private boolean compareString(String a, String b)
104    {
105        int diff = 0;
106        if(a.length() != b.length() )
107            return false;
108        else
109        {
110            for(int i=0;i <a.length()  ;i++)
111            {
112                if(a.charAt(i) != b.charAt(i))
113                    diff++;
114            }
115
116        }    
117        if(diff == 1)
118            return true;
119        return false;
120    }
121}