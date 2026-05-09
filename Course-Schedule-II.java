1class Solution {
2    List<List<Integer>> adjList;
3    int[] indegree;
4    int[] sol;
5    public int[] findOrder(int numCourses, int[][] prerequisites) 
6    {
7        indegree = new int[numCourses];
8        adjList = new ArrayList<List<Integer>>();
9        sol = new int[numCourses];
10         for(int i=0;i<numCourses;i++)
11        {
12            adjList.add(new ArrayList<Integer>());
13        }
14        for(int i=0;i<prerequisites.length;i++)
15        {
16            indegree[prerequisites[i][0]]++;
17            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
18        }
19
20        List<Integer> currList= new ArrayList<Integer>();
21        for(int i=0;i<numCourses;i++)
22        {
23            if(indegree[i] == 0)
24                currList.add(i);
25            
26        }
27        int index =0 ;
28        while(!currList.isEmpty())
29        {
30            List<Integer> child = new ArrayList<Integer>();
31            while(!currList.isEmpty())
32            {
33                int course = currList.removeFirst();
34                List<Integer> neighbors= adjList.get(course);
35                sol[index++] = course;
36                
37                for(int neighbor : neighbors)
38                {
39                    indegree[neighbor]--;
40                    if(indegree[neighbor] == 0)
41                        child.add(neighbor);
42                }
43            }
44            currList.addAll(child);
45
46        }
47        //  for(int i=0;i<numCourses;i++)
48        // {
49        //    System.out.print(sol[i] + " ");
50        // }
51        if(index == numCourses)
52            return sol;
53        else
54            return new int[0];
55        
56    }
57}