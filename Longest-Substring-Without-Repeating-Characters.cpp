1class Solution {
2public:
3    int lengthOfLongestSubstring(string s) 
4    {
5        unordered_set<char> hasSeen;
6        int l=0, r=0, maxLength =0;
7        for(r=0;r<s.length();)
8        {
9            while(l< r && hasSeen.count(s[r]) > 0)
10            {
11                hasSeen.erase(s[l]);
12                l++;
13
14            }
15            hasSeen.insert(s[r]);
16            r++;
17            if(maxLength < r-l)
18            {
19                maxLength = r-l;
20            }
21        }
22        return maxLength;
23    }
24};