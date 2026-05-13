1class Solution {
2public:
3    int eraseOverlapIntervals(vector<vector<int>>& intervals) 
4    {
5        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {return a[1] < b[1];});
6        int currEnd = intervals[0][1];
7        int count =1;
8        for(int i=1;i<intervals.size(); i++)
9        {
10            if(intervals[i][0] >= currEnd)
11            {
12                currEnd = intervals[i][1];
13                count++;
14            }
15        }
16        return intervals.size() - count;
17    }
18};