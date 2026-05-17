1class Solution {
2public:
3    vector<int> maxSlidingWindow(vector<int>& nums, int k) 
4    {
5       
6        deque<pair<int,int>> maxCandidates;
7        int max= INT_MIN;
8        vector<int> ans;
9        if(k >= nums.size())
10        {
11            for(int i=0;i<nums.size();i++)
12            {
13                if(max < nums[i])
14                {
15                    max = nums[i];
16                }
17            }
18            ans.push_back(max);
19            return ans;
20        }
21
22        for(int i=0;i<k;i++)
23            {
24                while(!maxCandidates.empty() && maxCandidates.back().first <= nums[i])
25                {
26                    maxCandidates.pop_back();
27                }
28                maxCandidates.push_back({nums[i], i});
29            }
30        ans.push_back(maxCandidates.front().first);
31
32
33        for(int i=1;i<=nums.size()-k;i++)
34        {
35            
36            if(!maxCandidates.empty() && maxCandidates.front().second < i)
37                maxCandidates.pop_front();
38            while(!maxCandidates.empty() && maxCandidates.back().first <= nums[i+ k-1])
39            {
40               // cout<<"Popped " <<maxCandidates.back().first<<endl;
41                maxCandidates.pop_back();
42            }
43            maxCandidates.push_back({nums[i+ k-1],i+ k-1});
44            ans.push_back(maxCandidates.front().first);
45        }
46        return ans;
47        
48    }
49};
50