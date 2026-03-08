1class Solution {
2public:
3    int is_ss(string &s, int start_index, int end_index, vector<vector<int>> &dp)
4    {
5        //cout<<"i: "<<start_index<<" j: "<<end_index<<endl;
6        if( start_index >= end_index)
7        {
8            dp[start_index][end_index] = true;
9            return true;
10        
11        }
12        if( dp[start_index][end_index] == -1)
13        {
14            if(s[start_index] == s[end_index])
15                dp[start_index][end_index] = true && is_ss(s,start_index+1,end_index-1,dp);
16            else
17                dp[start_index][end_index] = false;
18        }
19        return dp[start_index][end_index];
20    }
21    string longestPalindrome(string s) {
22        vector<vector<int>> dp;
23        for(int i=0;i<s.length();i++)
24        {
25            vector<int> vec;
26            for(int j=0;j<s.length();j++)
27                vec.push_back(-1);
28            dp.push_back(vec);
29        }
30        int max = 0;
31        int start =-1;
32        for(int i=0;i< s.length();i++)
33        {
34            for(int j=i;j<s.length();j++)
35            {
36                //cout<<" Called "<<"i: "<<i<<" j:"<<j<<endl;
37                int answer = is_ss(s, i, j, dp);
38                //cout<<answer<<" "<<"i: "<<i<<" j:"<<j<<endl;
39                if(answer && j-i+1 > max)
40                {
41                    max = j - i+1;
42                    start = i;
43                }
44            }
45        }
46        return s.substr(start, max);
47
48    }
49
50};