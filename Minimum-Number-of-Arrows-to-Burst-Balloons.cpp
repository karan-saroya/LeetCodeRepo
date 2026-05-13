1class Solution {
2public:
3    int findMinArrowShots(vector<vector<int>>& points) 
4    {
5        sort(points.begin(), points.end(), [](const vector<int>& a, const vector<int>& b) { return a[0] == b[0] ? a[1] <= b[1] :  a[0] <= b[0];});
6        int ans = 0;
7        int start= points[0][0], end = points[0][1];
8        for(int i=1;i<points.size();i++)
9        {
10            int startCurr = points[i][0];
11            int endCurr = points[i][1];
12            if(startCurr <= end)
13            {
14                start = startCurr;
15                end = min(end, endCurr);
16            }
17            else
18            {
19                ans++;
20                start= startCurr ;
21                end = endCurr;
22            }
23
24        }    
25
26        return ans+1;
27    }
28};