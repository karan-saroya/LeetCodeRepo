class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<int> > freq_arr;
        unordered_map<string, vector<string> > has_seen_freq;
        vector<vector<string> > answer;
        for(string str: strs)
        {
            vector<int> freqs= {};
            for(int i=0;i<26;i++)
                freqs.push_back(0);
            for(int i=0;i<str.length();i++)
            {
                freqs[str[i]- 'a'] = freqs[str[i] - 'a'] + 1;
            }
            freq_arr.push_back(freqs);
        }
        
        for(int i=0;i<freq_arr.size();i++)
        {
            stringstream ss_wd;
            for(int j : freq_arr[i])
            {
                ss_wd<<to_string(j)+"-";
            }
            string to_find = ss_wd.str();
            auto iter = has_seen_freq.find(to_find);
            if ( iter != has_seen_freq.end())
            {
                (iter->second).push_back(strs[i]);
            }
            else
                has_seen_freq.insert({to_find, vector<string>{strs[i]}});

        }

        for(auto it : has_seen_freq)
        {
            answer.push_back(it.second);
        }
        return answer;
    }
};