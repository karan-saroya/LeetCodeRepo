1
2class Solution {
3public:
4    vector<int> topKFrequent(vector<int>& nums, int k) {
5        vector<vector<int> > bucket;
6        unordered_map<int,int> hashmap;
7        vector<int> answer;
8        for(int i=0;i<=nums.size();i++)
9            bucket.push_back(vector<int>());
10
11        for(int i=0; i < nums.size() ; i++)
12        {
13            auto iter  = hashmap.find(nums[i]);
14            if( iter == hashmap.end())
15                hashmap.insert({nums[i],1});
16            else
17                iter->second = iter->second + 1 ;
18        }
19
20        for(auto it: hashmap)
21        {
22            (bucket[it.second]).push_back(it.first);
23        }
24        
25        for(auto it = bucket.rbegin(); it != bucket.rend() ; it++ )
26        {
27            if (answer.size() == k)
28                break;
29            vector<int> list= *it;
30            for(auto val : list)
31                answer.push_back(val);
32        }
33
34        return answer;
35
36    }
37};