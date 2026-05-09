1class Solution {
2    Map<Character, List<Character>> adjList;
3    Map<Character, Integer> indegree;
4    public String alienOrder(String[] words) 
5    {
6        HashSet<Character> hSet = new HashSet<Character>();
7        String sol ="";
8        for(int i=0;i<words.length;i++)
9        {
10            for(int j=0;j<words[i].length();j++)
11            {
12                if(!hSet.contains(words[i].charAt(j)))
13                {
14                    hSet.add(words[i].charAt(j));
15                }
16            }
17        }
18
19        indegree = new HashMap<Character, Integer>();
20        adjList =  new HashMap<Character, List<Character>>();
21
22        for(Character c : hSet)
23        {
24            indegree.put(c, Integer.valueOf(0));
25            adjList.put(c, new ArrayList<Character>());
26        }
27
28        for(int i=1;i<words.length;i++)
29        {
30            char[] edge = compare(words[i-1], words[i]);
31            if(edge != null)
32            {
33                adjList.get(edge[0]).add(edge[1]);
34                indegree.merge(edge[1], 1, Integer::sum);
35            }
36            else
37            {
38                if(words[i-1].length() > words[i].length())
39                    return "";
40            }
41        }
42        
43        List<Character> currList = new ArrayList<Character>();
44
45        for(Character c : hSet)
46        {
47            if(indegree.get(c) == 0)
48                currList.add(c);
49
50        }
51
52
53
54        while(!currList.isEmpty())
55        {
56            List<Character> child = new ArrayList<Character>();
57            while(!currList.isEmpty())
58            {
59                Character currChar = currList.removeFirst();
60                sol+=currChar;
61                List<Character> neighbors = adjList.get(currChar);
62                for(Character neighbor : neighbors)
63                {
64                    indegree.merge(neighbor, -1, Integer::sum);                
65                    if(indegree.get(neighbor) == 0)
66                        child.add(neighbor);
67                }
68                
69            }
70            currList.addAll(child);
71
72        }
73
74
75        if(sol.length() != hSet.size())
76            return "";
77        return sol;
78
79
80        
81    }
82    private char[] compare(String a, String b)
83    {
84        for(int i=0;i<Math.min(a.length(), b.length());i++)
85        {
86            if(a.charAt(i) != b.charAt(i))
87            {
88                char[] ans = new char[2];
89                ans[0] = a.charAt(i);
90                ans[1] = b.charAt(i);
91
92                return ans;
93            }
94        }
95        return null;
96    }
97
98}