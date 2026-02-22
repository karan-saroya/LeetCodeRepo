
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<vector<int> > bucket;
        unordered_map<int,int> hashmap;
        vector<int> answer;
        for(int i=0;i<=nums.size();i++)
            bucket.push_back(vector<int>());

        for(int i=0; i < nums.size() ; i++)
        {
            auto iter  = hashmap.find(nums[i]);
            if( iter == hashmap.end())
                hashmap.insert({nums[i],1});
            else
                iter->second = iter->second + 1 ;
        }

        for(auto it: hashmap)
        {
            (bucket[it.second]).push_back(it.first);
        }
        
        for(auto it = bucket.rbegin(); it != bucket.rend() ; it++ )
        {
            if (answer.size() == k)
                break;
            vector<int> list= *it;
            for(auto val : list)
                answer.push_back(val);
        }

        return answer;

    }
};