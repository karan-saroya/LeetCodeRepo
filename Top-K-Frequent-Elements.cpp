1
2class Solution {
3public:
4    vector<int> topKFrequent(vector<int>& nums, int k) {
5        vector<vector<int>> list;
6        unordered_map<int, int> mapIndex;
7        for(int i=0;i<nums.size();i++)
8        {
9            if(mapIndex.find(nums[i]) != mapIndex.end())
10            {
11                list[mapIndex[nums[i]]][1]++;
12            }
13            else
14            {
15                mapIndex[nums[i]] = list.size();
16                vector<int> vec{nums[i], 0};
17                list.push_back(vec);
18            }
19
20        }
21        auto cmp = [](vector<int>& a, vector<int>& b){return a[1] > b[1];};
22        sort(list.begin(), list.end(),cmp);
23        vector<int> ans;
24        for(int i=0;i<k;i++)
25        {
26            ans.push_back(list[i][0]);
27        }
28        return ans;
29    }
30};