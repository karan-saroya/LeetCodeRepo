class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> dict;
        vector<int> canBreakMemo;
        for(int i=0;i<s.length();i++)
            canBreakMemo.push_back(-1);
        for(int i=0;i< wordDict.size();i++)
            dict.insert(wordDict[i]);
        bool ans = false;
        string word = "";
        for(int i=0;i<s.length();i++)
        {
            word+=s[i];
            if(dict.find(word) != dict.end())
            {
                ans = ans || canBreak(i+1, s, dict,canBreakMemo);
            }


        }
        return ans;
    }
    bool canBreak(int start, string s, unordered_set<string>& dict, vector<int>& canBreakMemo)
    {
        if(start >= s.length())
            return true;
        else if(canBreakMemo[start] == -1)
        {
             string word = "";
        bool ans = false;
            for(int i=start;i<s.length();i++)
            {
                word+=s[i];
                if(dict.find(word) != dict.end())
                {
                    ans = ans || canBreak(i+1, s, dict,canBreakMemo );
                }
            }
            canBreakMemo[start] = ans;
            return ans;
        }
        else
            return canBreakMemo[start];
    }
};