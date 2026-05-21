1class Solution {
2    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) 
3    {
4        List<List<List<Double>>> adjList = new ArrayList<List<List<Double>>>();
5        double[] dist = new double[n];
6        Arrays.fill(dist, 0);
7
8        for(int i=0;i<n;i++)
9        {
10            ArrayList<List<Double>> list= new ArrayList<List<Double>>();
11            adjList.add(list);
12        }
13        for(int i=0;i<edges.length;i++)
14        {
15            int source = edges[i][0], dest = edges[i][1];
16            ArrayList<Double> list = new ArrayList<Double>();
17            list.add(succProb[i]);
18            list.add(Double.valueOf(dest));
19            adjList.get(source).add(list);
20            list = new ArrayList<Double>();
21            list.add(succProb[i]);
22            list.add( Double.valueOf(source));
23            adjList.get(dest).add(list);
24        }
25        dist[start_node] = 1;
26
27
28        PriorityQueue<List<Double>> maxHeap = new PriorityQueue<List<Double>>((a,b) -> Double.compare(b.get(0) , a.get(0)));
29        ArrayList<Double> startList = new ArrayList<Double>();
30        startList.add(Double.valueOf(1));
31        startList.add(Double.valueOf(start_node));
32        maxHeap.add(startList);
33        while(!maxHeap.isEmpty())
34        {
35            List<Double> currList = maxHeap.poll();
36            double prob = currList.get(0);
37            int currNode = (int)Math.round(currList.get(1));
38
39            if(prob > dist[currNode])
40                dist[currNode] = prob;
41            
42            List<List<Double>> neighbors = adjList.get(currNode);
43            for(List<Double> neighbor : neighbors)
44            {
45                prob =  neighbor.get(0);
46                int destNode  = (int)Math.round(neighbor.get(1));
47                if(dist[currNode] * prob > dist[destNode])
48                {
49                    dist[destNode] = dist[currNode] * prob;
50                    ArrayList<Double> newNode = new ArrayList<Double>();
51                    newNode.add(dist[destNode]);
52                    newNode.add(Double.valueOf(destNode));
53                    maxHeap.add(newNode);
54                }
55
56            }
57
58        }
59        return dist[end_node];
60    }
61}