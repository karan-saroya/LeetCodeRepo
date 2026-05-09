class Solution {
    public int minCostConnectPoints(int[][] points) 
    {
        List<int[]> edges = new ArrayList<int[]>();
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                int dist =(int) Math.abs(points[i][0] - points[j][0]) + (int)Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dist});
            }

        }

        edges.sort((a,b) -> Integer.compare(a[2], b[2]));
        DSU dsu = new DSU(points.length);
        int cost = 0;
        int num_edges = 0;
        for(int[] edge : edges)
        {

            if(dsu.union(edge[0], edge[1]))
            {
                num_edges++;
                cost+= edge[2];
            }
            if(num_edges == points.length-1)
                break;
        } 
        return cost;
    }
}
class DSU
{
    int[] parent;
    int[] rank;

    DSU(int n)
    {
        parent = new int[n];
        rank = new int [n];
        for(int i=0;i<n ;i++) parent[i] = i;


    }
    int find(int x)
    {
        if(parent[x]!= x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int x, int y)
    {   
        int px = find(x) , py = find(y);
        if(px == py)
            return false;

        if(rank[px] > rank[py])
            parent[py] = px;
        else if( rank[py] > rank[px])
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



}