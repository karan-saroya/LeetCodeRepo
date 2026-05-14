1class Solution {
2public:
3    int ladderLength(string beginWord, string endWord, vector<string>& wordList) 
4    {
5        bool isEnd = false;
6        int endIndex ;
7        int startIndex =-1;
8       for(int i=0;i<wordList.size();i++)
9        {
10            if(endWord == wordList[i])
11                {
12                    isEnd = true;
13                    endIndex = i;
14                }
15            if(wordList[i] == beginWord)
16                {
17                    startIndex = i;
18                }
19        }
20
21        if(!isEnd)
22            return 0;
23        if(startIndex == -1)
24            {
25                wordList.push_back(beginWord);
26                startIndex = wordList.size() -1;
27            }
28       // cout<<"Start word at "<< startIndex<<" End word at:"<< endIndex<< endl;
29        int adjMat[wordList.size()][wordList.size()];
30        bool visited[wordList.size()];
31        int dist[wordList.size()];
32        for(int i=0;i<wordList.size();i++)
33        {
34            for(int j=0;j<wordList.size();j++)
35            {
36                adjMat[i][j] = 0;
37                if(j!=i)
38                {
39                    if(reach(wordList[i], wordList[j]))
40                    {
41                        adjMat[j][i] = 1;
42                        adjMat[i][j] = 1;
43                    }
44                }
45            }
46        }
47
48        //  for(int i=0;i<wordList.size();i++)
49        // {
50        //     for(int j=0;j<wordList.size();j++)
51        //     {
52        //        cout<<adjMat[i][j]<< ",";
53        //     }
54        //     cout<<endl;
55        // }
56
57
58        for(int i=0;i<wordList.size();i++)
59            {
60                dist[i] = INT_MAX;
61                visited[i] = false;
62            }
63        visited[startIndex ] = true;
64        dist[startIndex ] = 0;
65        
66        // for(int i=0;i<wordList.size();i++)
67        //     {
68        //         cout<<visited[i]<<" ";
69        //     }
70        // cout<<endl;
71        queue<int> currList;
72        currList.push(startIndex);
73
74        while(!currList.empty())
75        {
76            queue<int> child;
77            while(!currList.empty())
78            {
79                int word = currList.front();
80                currList.pop();
81                //cout<<"Popped: "<<word<<endl;
82                for(int i=0;i<wordList.size();i++)
83                {
84                
85                    if(adjMat[word][i] == 1 && !visited[i])
86                    {
87                        //cout<<i<<" ";
88                        visited[i] = true;
89                        dist[i] = dist[word] +1;
90                        child.push(i);
91                    }
92                }
93                cout<<endl;
94            }
95            while(!child.empty())
96            {
97                currList.push(child.front());
98                //cout<<"Index :"<< child.front()<< " ";
99                child.pop();
100            }
101            cout<<endl;
102        }
103
104        if(dist[endIndex] == INT_MAX)
105            return 0; 
106        return dist[endIndex] +1 ;
107
108    }
109    bool reach(string s, string d)
110    {
111        int diff= 0;
112        for(int i=0;i<s.length();i++)
113        {
114            if(s[i] != d[i])
115                diff++;
116        }
117
118        if(diff == 1)
119            return true;
120        return false;
121    }
122};