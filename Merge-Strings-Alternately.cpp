1class Solution {
2public:
3    string mergeAlternately(string word1, string word2) {
4        std::string mergedStr= "";
5        for(int i=0;i< min(word1.length(), word2.length()); i++)
6        {
7            mergedStr+= word1[i];
8            mergedStr+= word2[i];
9        }   
10
11        if(word1.length() >= word2.length())
12            mergedStr += word1.substr(word2.length(), word1.length());
13        else
14            mergedStr += word2.substr(word1.length(), word2.length());
15        return mergedStr;
16    }
17};