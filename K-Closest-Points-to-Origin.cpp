1class Solution {
2    public int[][] kClosest(int[][] points, int k) 
3    {
4        PriorityQueue<int[]> pointsSorted = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[0]*a[0]+ a[1]*a[1], b[0]*b[0]+ b[1]*b[1]));
5
6        for(int i=0;i<points.length;i++)
7        {
8            pointsSorted.offer(points[i]);
9        }
10
11        int[][] ans  = new int[k][2];
12        for(int i=0;i<k;i++)
13        {
14            ans[i] = pointsSorted.poll();
15        }
16
17        return ans;
18
19        
20    }
21}