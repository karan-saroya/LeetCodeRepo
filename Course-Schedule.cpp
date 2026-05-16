1class Solution {
2public:
3    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) 
4    {
5        vector<vector<int>> adjList;
6        vector<int> inDegree;    
7        queue<int> currList;
8        for(int i=0;i<numCourses;i++)
9        {
10            inDegree.push_back(0);
11            vector<int> list;
12            adjList.push_back(list);
13        } 
14
15        for(int i=0;i<prerequisites.size();i++)
16        {
17            int dest = prerequisites[i][0], source = prerequisites[i][1];
18            adjList[source].push_back(dest);
19            inDegree[dest]++;
20        }
21        
22        for(int i=0;i<numCourses;i++)
23        {
24            if(inDegree[i] == 0)
25                currList.push(i);
26        } 
27        vector<int> order;
28        while(!currList.empty())
29        {
30            int course = currList.front();
31            currList.pop();
32            order.push_back(course);
33            vector<int> dependents = adjList[course];
34            for(int dependent: dependents )
35            {
36                inDegree[dependent]--;
37                if(inDegree[dependent] == 0)
38                    currList.push(dependent);
39            }
40        }
41
42        if(order.size() == numCourses)
43            return true;
44        return false;
45
46    }
47};