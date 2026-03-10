1class Solution {
2public:
3    string convert(string s, int numRows) 
4    {
5        vector<string> comb;
6        for(int i=0;i<=numRows;i++)
7        {
8            comb.push_back("");
9        }
10        int index = 0;
11        while(index < s.length())
12        {
13            int forward = 1;
14            while(index < s.length() && forward <= numRows)
15            {
16                comb[forward] +=s[index];
17                forward++;
18                index++;
19            }
20            int rev = numRows-1;
21            while(rev >1 && index < s.length())
22            {
23                comb[rev] +=s[index];
24                rev--;
25                index++;
26            }
27        }
28        string ans="";
29        for(int i=1;i<comb.size();i++)
30        {
31            ans+=comb[i];
32        }
33        return ans;
34
35    }
36
37        
38    };