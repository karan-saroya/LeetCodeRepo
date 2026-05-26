1class TreeAncestor {
2    int[] par;
3    int LOG= 32;
4    int[][] dp;
5    public TreeAncestor(int n, int[] parent) 
6    {
7        par = new int[parent.length];
8        dp = new int[parent.length][LOG];
9        par = parent;
10        for(int i=0;i<parent.length;i++)
11            Arrays.fill(dp[i], -1);
12        for(int i=0;i<parent.length;i++)
13            dp[i][0] = parent[i];
14
15        for(int k=1;k<LOG;k++)
16        {
17            for(int i=0;i<parent.length;i++)
18            {
19                int mid = dp[i][k-1];
20                if(mid != -1)
21                {
22                    dp[i][k] = dp[mid][k-1];
23                }
24            }
25
26        }    
27
28    }
29    
30    public int getKthAncestor(int node, int k) 
31    {
32
33
34        for(int i=0;i<LOG && node != -1;i++)
35        {
36            if((k & (1 << i)) != 0)
37            {
38                node  = dp[node][i];
39            }
40        }
41        return node;
42
43
44        
45    }
46    
47}
48
49/**
50 * Your TreeAncestor object will be instantiated and called as such:
51 * TreeAncestor obj = new TreeAncestor(n, parent);
52 * int param_1 = obj.getKthAncestor(node,k);
53 */