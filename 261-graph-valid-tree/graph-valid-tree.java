class Solution {
    public boolean validTree(int n, int[][] edges) 
    {
        if(edges.length != n-1)
            return false;
        DSU dsu = new DSU(n);
        for(int i=0;i<edges.length;i++)
        {
            dsu.union(edges[i][0], edges[i][1]);
        }

        if(dsu.numComps() == 1)
            return true;


        return false;

        
        
    }
}

class DSU
{
    int[] parent;
    int[] rank;
    DSU(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
        }



    }

    int find(int x)
    {
        if(parent[x]!= x)
            parent[x] = find(parent[x]);
        
        return parent[x];
    }
    
    boolean union(int x, int y)
    {
        int px = find(x), py = find(y);
        if(px == py)
            return false;
        
        if(rank[px] > rank[py])
            parent[py] = px;
        else if(rank[py] > rank[px])
            parent[px] = py;
        else
        {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }

    int numComps()
    {
        HashSet<Integer> hSet = new HashSet<Integer>();
        for(int i=0;i<parent.length;i++)
        {
            if(!hSet.contains(find(i)))
            {
                hSet.add(parent[i]);
            }
        }

        return hSet.size();
    }


}