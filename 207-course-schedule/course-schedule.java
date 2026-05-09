class Solution {
    List<List<Integer>> adj_list;
    int[] indegree;
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        indegree = new int[numCourses];
        adj_list = new ArrayList<List<Integer>>();
        for(int i=0;i<numCourses ;i++)
        {
            List<Integer> neighbor= new ArrayList<Integer>();
            adj_list.add(neighbor);
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            adj_list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        List<Integer> currList = new ArrayList<Integer>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i] == 0)
                currList.add(i);
        }
        int poppedCount= 0;
        while(!currList.isEmpty())
        {
            List<Integer> child = new ArrayList<Integer>();
            while(!currList.isEmpty())
            {
                int course = currList.removeFirst();
                poppedCount++;
                List<Integer> neighbor = adj_list.get(course);
                for(int i=0;i< neighbor.size();i++)
                {
                    indegree[neighbor.get(i)]--;
                    if(indegree[neighbor.get(i)] == 0)
                        child.add(neighbor.get(i));
                }
            }

            currList.addAll(child);
        }

    if(poppedCount == numCourses)
            return true;
    return false;   
    }
    
}