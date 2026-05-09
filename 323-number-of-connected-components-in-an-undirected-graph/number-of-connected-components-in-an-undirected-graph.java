class Solution {
    public int countComponents(int n, int[][] edges) 
    {
        DSU dsu = new DSU(n);
        System.out.println("here");
        for(int i=0;i<edges.length;i++)
        {
            dsu.union(edges[i][0], edges[i][1]);
        }
        //System.out.println("Noiw here ");
        return dsu.findComponents();
        
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
            parent[i]= i;
            rank[i]= 0;
        }

    }
    int find(int x)
    {
        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    boolean union(int x, int y)
    {
        //System.out.println("Find called for "+ x + " "+ y);
        int px = find(x), py = find(y);
        //System.out.println("Find finished");
        if(px == py)
            return false;
        if(rank[px] > rank[py])
        {
            parent[py] = px;
        }
        else if(rank[py] > rank[px])
        {
            parent[px] = py;

        }
        else
        {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
    int findComponents()
    {
        HashSet<Integer> hSet = new HashSet<Integer>();
        for(int i=0;i<parent.length;i++)
        {
            if(!hSet.contains(find(i)))
            {
                hSet.add(parent[i]);
            }
        }
        // System.out.println("Parents");
        // for(int i=0;i<parent.length;i++)
        // {
        //     System.out.println(parent[i]);
        // }

        // System.out.println("Parents end");
         return hSet.size();
    }


}