#include<climits>
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> unique_set;
        int max =  INT_MIN;
        for(int i=0;i<nums.size();i++)
        {
            unique_set.insert(nums[i]);
            if (nums[i] > max)
                max= nums[i];
        }
        int answer=0;
         for(auto iter=unique_set.begin();iter!= unique_set.end();iter++)
        {
            
            if(unique_set.find(*iter-1) != unique_set.end())
                continue;
            else
            {
                int max_length=1;
                // can be the starting of the max seq!
                for(int j=*iter + 1; j<=max;j++)
                    {
                        if(unique_set.find(j) != unique_set.end())
                            {
                                max_length++;
                            }
                        else
                            break;
                    }
                if(max_length > answer)
                    answer=max_length;
            }
        }

        return answer;
    }
};