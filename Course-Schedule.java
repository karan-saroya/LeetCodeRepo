1class Solution {
2    List<List<Integer>> adj_list;
3    int[] indegree;
4    public boolean canFinish(int numCourses, int[][] prerequisites) 
5    {
6        indegree = new int[numCourses];
7        adj_list = new ArrayList<List<Integer>>();
8        for(int i=0;i<numCourses ;i++)
9        {
10            List<Integer> neighbor= new ArrayList<Integer>();
11            adj_list.add(neighbor);
12        }
13        for(int i=0;i<prerequisites.length;i++)
14        {
15            adj_list.get(prerequisites[i][1]).add(prerequisites[i][0]);
16            indegree[prerequisites[i][0]]++;
17        }
18        List<Integer> currList = new ArrayList<Integer>();
19        for(int i=0;i<numCourses;i++)
20        {
21            if(indegree[i] == 0)
22                currList.add(i);
23        }
24        int poppedCount= 0;
25        while(!currList.isEmpty())
26        {
27            List<Integer> child = new ArrayList<Integer>();
28            while(!currList.isEmpty())
29            {
30                int course = currList.removeFirst();
31                poppedCount++;
32                List<Integer> neighbor = adj_list.get(course);
33                for(int i=0;i< neighbor.size();i++)
34                {
35                    indegree[neighbor.get(i)]--;
36                    if(indegree[neighbor.get(i)] == 0)
37                        child.add(neighbor.get(i));
38                }
39            }
40
41            currList.addAll(child);
42        }
43
44    if(poppedCount == numCourses)
45            return true;
46    return false;   
47    }
48    
49}