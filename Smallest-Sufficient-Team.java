1class Solution {
2    int[][] dp;
3    boolean[][] take;
4    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) 
5    {
6        HashMap<String, Integer> hMap = new HashMap<String, Integer>();
7    
8        for(int i=0;i<req_skills.length;i++)
9        {
10            hMap.put(req_skills[i],i);
11        }
12
13        int maxMask = (1<<req_skills.length);
14        dp = new int[people.size()][maxMask];
15        take = new boolean[people.size()][maxMask];
16        //System.out.println(maxMask);
17        for(int i=0;i<people.size();i++)
18        {
19            Arrays.fill(dp[i], -1);
20            Arrays.fill(take[i], false);
21        }
22        
23       minCost(0, 0, maxMask-1,people,hMap);
24        ArrayList<Integer> ans = new ArrayList<Integer>();
25        int startPos = 0, startMask = 0;
26        while(true)
27        {
28            if(startPos >= take.length)
29                break;
30            if( startMask > maxMask)
31                break;
32            if(take[startPos][startMask])
33            {
34
35                List<String> skills = people.get(startPos);
36                int newMask = startMask;
37                for(int i=0;i<skills.size();i++)
38                {
39                    int currIndex = hMap.get(skills.get(i));
40                    newMask = (newMask |(1<<currIndex));
41                }
42                ans.add(startPos);
43                startPos++;
44                startMask = newMask;
45            }
46            else
47            {
48                startPos = startPos+1;
49
50            }
51        }
52        return ans.stream().mapToInt(Integer::intValue).toArray();
53    }
54    public int minCost(int index, int currMask,int maxMask, List<List<String>> people, HashMap<String, Integer> hMap)
55    {
56        if(currMask == maxMask)
57            return 0;
58        if(index == people.size())
59            return Integer.MAX_VALUE;
60        if(dp[index][currMask] != -1)
61            return dp[index][currMask];
62        // either take this or not
63        List<String> skills = people.get(index);
64        int newMask = currMask;
65        for(int i=0;i<skills.size();i++)
66        {
67            int currIndex = hMap.get(skills.get(i));
68            newMask = (newMask |(1<<currIndex));
69        }
70
71        int with = minCost(index+1,newMask, maxMask, people, hMap);
72        if(with != Integer.MAX_VALUE)
73            with+=1;
74        int wo = minCost(index+1, currMask, maxMask, people, hMap);
75        int ans = Math.min(with, wo);
76        
77        
78
79        dp[index][currMask] = ans;
80        if(with < wo)
81        {
82            
83            take[index][currMask] = true;
84        }
85        else
86        {
87            take[index][currMask] = false;
88        }
89        return ans;
90        
91    }
92}