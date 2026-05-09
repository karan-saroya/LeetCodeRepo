class Solution {
    Map<Character, List<Character>> adjList;
    Map<Character, Integer> indegree;
    public String alienOrder(String[] words) 
    {
        HashSet<Character> hSet = new HashSet<Character>();
        String sol ="";
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words[i].length();j++)
            {
                if(!hSet.contains(words[i].charAt(j)))
                {
                    hSet.add(words[i].charAt(j));
                }
            }
        }

        indegree = new HashMap<Character, Integer>();
        adjList =  new HashMap<Character, List<Character>>();

        for(Character c : hSet)
        {
            indegree.put(c, Integer.valueOf(0));
            adjList.put(c, new ArrayList<Character>());
        }

        for(int i=1;i<words.length;i++)
        {
            char[] edge = compare(words[i-1], words[i]);
            if(edge != null)
            {
                adjList.get(edge[0]).add(edge[1]);
                indegree.merge(edge[1], 1, Integer::sum);
            }
            else
            {
                if(words[i-1].length() > words[i].length())
                    return "";
            }
        }
        
        List<Character> currList = new ArrayList<Character>();

        for(Character c : hSet)
        {
            if(indegree.get(c) == 0)
                currList.add(c);

        }



        while(!currList.isEmpty())
        {
            List<Character> child = new ArrayList<Character>();
            while(!currList.isEmpty())
            {
                Character currChar = currList.removeFirst();
                sol+=currChar;
                List<Character> neighbors = adjList.get(currChar);
                for(Character neighbor : neighbors)
                {
                    indegree.merge(neighbor, -1, Integer::sum);                
                    if(indegree.get(neighbor) == 0)
                        child.add(neighbor);
                }
                
            }
            currList.addAll(child);

        }


        if(sol.length() != hSet.size())
            return "";
        return sol;


        
    }
    private char[] compare(String a, String b)
    {
        for(int i=0;i<Math.min(a.length(), b.length());i++)
        {
            if(a.charAt(i) != b.charAt(i))
            {
                char[] ans = new char[2];
                ans[0] = a.charAt(i);
                ans[1] = b.charAt(i);

                return ans;
            }
        }
        return null;
    }

}