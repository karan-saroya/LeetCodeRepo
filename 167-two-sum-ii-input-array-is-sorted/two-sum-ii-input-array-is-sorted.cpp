class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        unordered_map<int, int> has_seen_complement;
        size_t  index=1;
        vector<int> answer;
        for(auto i: numbers)
        {
            auto iter = has_seen_complement.find(i);
            if(iter != has_seen_complement.end())
            {
                answer.push_back(iter->second);
                answer.push_back(index);
                break;
            }
            else
            {
                // add the complement along with position
                has_seen_complement.insert({target-i,index});
                index++;
            }
        }
        return answer;
    }
};