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
18                if(heights[i] == (minStack.top()).first)
19                    rightMin[currEle.second] = i;
20                else
21                    rightMin[currEle.second] = i-1;
22                minStack.pop();
23            }
24
25            minStack.push({heights[i],i});
26        }
27        while(!minStack.empty())
28        {
29            minStack.pop();
30        }
31        //stack<pair<int,int>> empty;
32        //swap(minStack, empty);
33        for(int i=heights.size()-1;i>=0;i--)
34        {
35            while(!minStack.empty() &&(minStack.top()).first > heights[i])
36            {
37                
38                    pair<int, int> currEle  = minStack.top();
39                    
40                    if(heights[i] == (minStack.top()).first)
41                        leftMin[currEle.second] = i;
42                    else
43                        leftMin[currEle.second] = i+1;
44
45                    minStack.pop();
46               
47                
48            }
49
50            minStack.push({heights[i],i});
51        }
52        int max = 0;
53        for(int i=0;i<heights.size();i++)
54        {
55            //cout<<"heigh: "<<heights[i] << " LeftMin:"<<leftMin[i]<<" RightMin: "<<rightMin[i]<<endl;
56            if(max < heights[i] * (rightMin[i] - leftMin[i] + 1))
57                max = heights[i] * (rightMin[i] - leftMin[i] + 1);
58        }
59        return max;
60    }
61};