1class Solution {
2public:
3    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) 
4    {
5       vector<vector<int>> ans;
6
7        int index= -1;
8       for(int i=0;i<intervals.size();i++)
9        {
10            if(intervals[i][0]>= newInterval[0])
11            {
12                index = i;
13                break;
14            }
15
16        }
17
18        if(index == -1)
19        {
20            index = intervals.size();
21        }
22        for(int i=0;i<index-1;i++)
23        {
24            ans.push_back(intervals[i]);
25        }
26        cout<<"Index is :" << index<<endl;
27        int start =  newInterval[0];
28        int end = newInterval[1];
29
30        if(index >=1 && intervals[index-1][1]>=newInterval[0])
31        {
32            start = min(newInterval[0], intervals[index-1][0]);
33            end = max(newInterval[1], intervals[index-1][1]);
34            
35        }
36        else if(index >= 1)
37        {
38            ans.push_back(intervals[index-1]);
39            start = newInterval[0];
40            end = newInterval[1];
41        }
42        
43        for(int i= index;i<intervals.size();i++)
44        {
45            if(end < intervals[i][0])
46            {
47                vector<int> vec{start,end};
48                ans.push_back(vec);
49                start = intervals[i][0];
50                end = intervals[i][1];
51            }
52            else
53            {
54                end = max(end, intervals[i][1]);
55            }
56        }
57
58        vector<int> vec{start,end};
59        ans.push_back(vec);
60        return ans;
61    }
62};