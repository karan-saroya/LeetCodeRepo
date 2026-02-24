1#include<climits>
2class Solution {
3public:
4    int longestConsecutive(vector<int>& nums) {
5        unordered_set<int> unique_set;
6        int max =  INT_MIN;
7        for(int i=0;i<nums.size();i++)
8        {
9            unique_set.insert(nums[i]);
10            if (nums[i] > max)
11                max= nums[i];
12        }
13        int answer=0;
14         for(auto iter=unique_set.begin();iter!= unique_set.end();iter++)
15        {
16            
17            if(unique_set.find(*iter-1) != unique_set.end())
18                continue;
19            else
20            {
21                int max_length=1;
22                // can be the starting of the max seq!
23                for(int j=*iter + 1; j<=max;j++)
24                    {
25                        if(unique_set.find(j) != unique_set.end())
26                            {
27                                max_length++;
28                            }
29                        else
30                            break;
31                    }
32                if(max_length > answer)
33                    answer=max_length;
34            }
35        }
36
37        return answer;
38    }
39};