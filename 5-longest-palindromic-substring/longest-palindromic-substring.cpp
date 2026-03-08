class Solution {
public:
    string expand(int i, int j, string s)
    {
        int max=0;
        cout<<"Entry i:"<<i<<" j:"<<j<<endl;
        while(i >= 0 && j < s.length() && s[i] == s[j])
        {
            if(j-i + 1 > max)
                max = j-i+1;
            
            //cout<<"Loop i:"<<i<<" j:"<<j<< " max:"<<max<<endl;
            
            i--;
            j++;
        }
        return s.substr(i+1, max);

    }
    string longestPalindrome(string s) {
        
        string evenAns = "", oddAns ="";
        for(int i=0;i<s.length();i++)
        {
            string ans = expand(i,i,s);
            if(ans.length() > evenAns.length())
                evenAns = ans;
        }

        for(int i=1;i<s.length();i++)
        {
            string ans = expand(i-1,i,s);
            if(ans.length() > oddAns.length())
                oddAns = ans;
        }
        if (evenAns.length() >= oddAns.length())
            return evenAns;
        else
            return oddAns;
    }

};