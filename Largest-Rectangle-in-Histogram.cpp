1class Solution {
2public:
3    int largestRectangleArea(vector<int>& heights) 
4    {
5        stack<pair<int,int>> minStack;
6        vector<int> leftMin, rightMin;
7        for(int i=0;i<heights.size();i++)
8            {
9                leftMin.push_back(0);
10                rightMin.push_back(heights.size() -1);
11            }
12        for(int i=0;i<heights.size();i++)
13        {
14            while(!minStack.empty() &&(minStack.top()).first > heights[i])
15            {
16                pair<int, int> currEle  = minStack.top();
17                
18               
19                    rightMin[currEle.second] = i-1;
20                minStack.pop();
21            }
22
23            minStack.push({heights[i],i});
24        }
25        // while(!minStack.empty())
26        // {
27        //     minStack.pop();
28        // }
29        stack<pair<int,int>> empty;
30        swap(minStack, empty);
31        for(int i=heights.size()-1;i>=0;i--)
32        {
33            while(!minStack.empty() &&(minStack.top()).first > heights[i])
34            {
35                
36                    pair<int, int> currEle  = minStack.top();
37                    
38                
39                        leftMin[currEle.second] = i+1;
40
41                    minStack.pop();
42               
43                
44            }
45
46            minStack.push({heights[i],i});
47        }
48        int max = 0;
49        for(int i=0;i<heights.size();i++)
50        {
51            //cout<<"heigh: "<<heights[i] << " LeftMin:"<<leftMin[i]<<" RightMin: "<<rightMin[i]<<endl;
52            if(max < heights[i] * (rightMin[i] - leftMin[i] + 1))
53                max = heights[i] * (rightMin[i] - leftMin[i] + 1);
54        }
55        return max;
56    }
57};