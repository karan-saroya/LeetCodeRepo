class Solution {
public:
    int lengthOfLongestSubstring(string s) 
    {
        // 2ptr approach 
        unordered_map<char, int> dup;
        int start=0, end=0;
        if(s.length() == 0)
            return 0;
        
        int max= 0;
        while(start <=end && start< s.length() && end < s.length())
        {
            if(start == end)
            {
                cout<<"Equal case start:"<<start<<" end: "<<end<<" max:" << max<<endl;
                dup[s[start]] =1;
                end++;
                if(max < 1)
                    max =1;
                continue;
            }
            auto iter = dup.find(s[end]);
            if(iter != dup.end() && iter->second > 0)
            {
                                cout<<"bad case start:"<<start<<" end: "<<end<<" max:" << max<<endl;

                // end already exists somewhere
                while(start <=end)
                {
                    if(s[start] != s[end])
                    {
                        dup[s[start]]--;   
                        start++;
                    }
                    else
                    {
                        start++;
                        dup[s[end]]--;
                        break;
                    }
                    

                }
            }
            else
            {
                cout<<"Good case start:"<<start<<" end: "<<end<<" max:" << max<<endl;
                dup[s[end]]++;
                if(end - start +1 > max)
                    max = end -start +1;
                end++;
            }

        }
        return max;
    }
};