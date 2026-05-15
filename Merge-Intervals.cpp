1class Solution {
2public:
3    vector<vector<int>> merge(vector<vector<int>>& intervals) 
4    {
5        auto cmp = [] (vector<int>& a, vector<int>& b) {return a[0] < b[0];};
6        sort(intervals.begin(), intervals.end(),cmp);
7        vector<vector<int>> ans;
8        int start= intervals[0][0];
9        int end = intervals[0][1];
10        
11        
12        for(int i=1;i<intervals.size();i++)
13        {
14            if(end < intervals[i][0])
15            {
16                vector<int> vec{start, end};
17                
18                ans.push_back(vec);
19
20                start = intervals[i][0];
21                end = intervals[i][1];
22            }
23            else
24            {
25                end = max(end, intervals[i][1]);
26            }
27            
28        }
29
30        vector<int> vec{start,end};
31        ans.push_back(vec);
32        
33        return ans;
34
35        
36    }
37};