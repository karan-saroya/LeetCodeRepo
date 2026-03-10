class Solution {
public:
    string convert(string s, int numRows) 
    {
        vector<string> comb;
        for(int i=0;i<=numRows;i++)
        {
            comb.push_back("");
        }
        int index = 0;
        while(index < s.length())
        {
            int forward = 1;
            while(index < s.length() && forward <= numRows)
            {
                comb[forward] +=s[index];
                forward++;
                index++;
            }
            int rev = numRows-1;
            while(rev >1 && index < s.length())
            {
                comb[rev] +=s[index];
                rev--;
                index++;
            }
        }
        string ans="";
        for(int i=1;i<comb.size();i++)
        {
            ans+=comb[i];
        }
        return ans;

    }

        
    };