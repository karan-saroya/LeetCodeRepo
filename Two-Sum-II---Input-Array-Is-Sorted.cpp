1class Solution {
2public:
3    vector<int> twoSum(vector<int>& numbers, int target) {
4        unordered_map<int, int> has_seen_complement;
5        size_t  index=1;
6        vector<int> answer;
7        for(auto i: numbers)
8        {
9            auto iter = has_seen_complement.find(i);
10            if(iter != has_seen_complement.end())
11            {
12                answer.push_back(iter->second);
13                answer.push_back(index);
14                break;
15            }
16            else
17            {
18                // add the complement along with position
19                has_seen_complement.insert({target-i,index});
20                index++;
21            }
22        }
23        return answer;
24    }
25};