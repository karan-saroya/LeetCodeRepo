class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        vector<int> maxSubArr;
        maxSubArr.push_back(nums[0]);
        int Max = nums[0];
        for(int i=1;i<nums.size();i++)
        {
            int ans = max(maxSubArr[i-1]+ nums[i] , nums[i]);
            maxSubArr.push_back(ans);
            if(ans > Max)
                Max = ans; 

        }
        return Max;

    }
};