1class Solution {
2public:
3    vector<vector<string>> groupAnagrams(vector<string>& strs) {
4        vector<vector<int> > freq_arr;
5        unordered_map<string, vector<string> > has_seen_freq;
6        vector<vector<string> > answer;
7        for(string str: strs)
8        {
9            vector<int> freqs= {};
10            for(int i=0;i<26;i++)
11                freqs.push_back(0);
12            for(int i=0;i<str.length();i++)
13            {
14                freqs[str[i]- 'a'] = freqs[str[i] - 'a'] + 1;
15            }
16            freq_arr.push_back(freqs);
17        }
18        
19        for(int i=0;i<freq_arr.size();i++)
20        {
21            stringstream ss_wd;
22            for(int j : freq_arr[i])
23            {
24                ss_wd<<to_string(j)+"-";
25            }
26            string to_find = ss_wd.str();
27            auto iter = has_seen_freq.find(to_find);
28            if ( iter != has_seen_freq.end())
29            {
30                (iter->second).push_back(strs[i]);
31            }
32            else
33                has_seen_freq.insert({to_find, vector<string>{strs[i]}});
34
35        }
36
37        for(auto it : has_seen_freq)
38        {
39            answer.push_back(it.second);
40        }
41        return answer;
42    }
43};