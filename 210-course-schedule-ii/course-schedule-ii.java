class Solution {
    List<List<Integer>> adjList;
    int[] indegree;
    int[] sol;
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        indegree = new int[numCourses];
        adjList = new ArrayList<List<Integer>>();
        sol = new int[numCourses];
         for(int i=0;i<numCourses;i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            indegree[prerequisites[i][0]]++;
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        List<Integer> currList= new ArrayList<Integer>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i] == 0)
                currList.add(i);
            
        }
        int index =0 ;
        while(!currList.isEmpty())
        {
            List<Integer> child = new ArrayList<Integer>();
            while(!currList.isEmpty())
            {
                int course = currList.removeFirst();
                List<Integer> neighbors= adjList.get(course);
                sol[index++] = course;
                
                for(int neighbor : neighbors)
                {
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0)
                        child.add(neighbor);
                }
            }
            currList.addAll(child);

        }
        //  for(int i=0;i<numCourses;i++)
        // {
        //    System.out.print(sol[i] + " ");
        // }
        if(index == numCourses)
            return sol;
        else
            return new int[0];
        
    }
}