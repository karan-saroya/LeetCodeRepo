1class Solution {
2public:
3    vector<int> dailyTemperatures(vector<int>& temperatures) 
4    {
5        stack<pair<int,int>> tempStack;
6        vector<int> ans;
7        for(int i=0;i<temperatures.size();i++)
8        {
9            ans.push_back(-1);
10        }
11        for(int i=0;i<temperatures.size();i++)
12        {
13            while(!tempStack.empty() &&tempStack.top().first < temperatures[i] )
14            {
15                pair<int, int> node = tempStack.top();
16                ans[node.second] = i - node.second;
17                tempStack.pop();
18            }
19
20            tempStack.push({temperatures[i], i});
21        }
22        for(int i=0;i<ans.size();i++)
23        {
24            if(ans[i] == -1)
25                ans[i] =0;
26        }
27        return ans;
28    }
29};