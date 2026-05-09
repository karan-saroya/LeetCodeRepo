class Solution {
    public int[] findRedundantConnection(int[][] edges) 
    {
        DSU dsu = new DSU(edges.length);
        int[] ans= new int[2];
        for(int i=0;i<edges.length;i++)
        {
            if(!dsu.union(edges[i][0]-1, edges[i][1]-1))
            {
                ans[0] = edges[i][0];
                ans[1] = edges[i][1];
                break;
            }
            
        }
        return ans;
    }
    
}

class DSU
{
    int[] parent;
    int[] rank;
    DSU(int n)
    {
        parent = new int [n];
        rank = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;


    }
    int find(int x)
    {
        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    boolean  union(int x, int y)
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



}
