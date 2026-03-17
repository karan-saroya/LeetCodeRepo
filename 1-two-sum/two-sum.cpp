class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> needComplement;
        bool found=false;
        vector<int> ans;
        for(int i=0;i<nums.size();i++)
        {
            if(needComplement.find(nums[i]) != needComplement.end())
            {
                found = true;
                ans.push_back(needComplement[nums[i]]);
                ans.push_back(i);
                break;
            }
            else
            {
                needComplement.insert({target-nums[i], i});
            }
        }
        return ans;
    }
};