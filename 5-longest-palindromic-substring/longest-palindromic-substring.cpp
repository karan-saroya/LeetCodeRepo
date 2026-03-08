class Solution {
public:
    int is_ss(string &s, int start_index, int end_index, vector<vector<int>> &dp)
    {
        //cout<<"i: "<<start_index<<" j: "<<end_index<<endl;
        if( start_index >= end_index)
        {
            dp[start_index][end_index] = true;
            return true;
        
        }
        if( dp[start_index][end_index] == -1)
        {
            if(s[start_index] == s[end_index])
                dp[start_index][end_index] = true && is_ss(s,start_index+1,end_index-1,dp);
            else
                dp[start_index][end_index] = false;
        }
        return dp[start_index][end_index];
    }
    string longestPalindrome(string s) {
        vector<vector<int>> dp;
        for(int i=0;i<s.length();i++)
        {
            vector<int> vec;
            for(int j=0;j<s.length();j++)
                vec.push_back(-1);
            dp.push_back(vec);
        }
        int max = 0;
        int start =-1;
        for(int i=0;i< s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                //cout<<" Called "<<"i: "<<i<<" j:"<<j<<endl;
                int answer = is_ss(s, i, j, dp);
                //cout<<answer<<" "<<"i: "<<i<<" j:"<<j<<endl;
                if(answer && j-i+1 > max)
                {
                    max = j - i+1;
                    start = i;
                }
            }
        }
        return s.substr(start, max);

    }

};